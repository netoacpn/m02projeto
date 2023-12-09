package tech.devinhouse.devinpharmacy.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharmacy.dto.ConsultaEstoqueResponse;
import tech.devinhouse.devinpharmacy.dto.EstoqueRequest;
import tech.devinhouse.devinpharmacy.dto.EstoqueTrocaRequest;
import tech.devinhouse.devinpharmacy.exceptions.CnpjFoundException;
import tech.devinhouse.devinpharmacy.exceptions.NroRegistroFoundException;
import tech.devinhouse.devinpharmacy.exceptions.QuantidadeMaiorException;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.repository.EstoqueRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EstoqueService {

  @Autowired
  private EstoqueRepository estoqueRepository;

  @Autowired
  private MedicamentoService medicamentoService;

  @Autowired
  private FarmaciaService farmaciaService;

  @Autowired
  private ModelMapper mapper;


  public Estoque saveEstoque(Estoque estoque) {
    return estoqueRepository.save(estoque);
  }

  public Optional<List<ConsultaEstoqueResponse>> getEstoqueByCnpj(Long cnpj) {

    Optional<List<Estoque>> estoques = estoqueRepository.findByCnpj(cnpj);

    return estoques.map(estoqueList ->
        estoqueList.stream()
            .map(estoque -> new ConsultaEstoqueResponse(
                estoque.getNroRegistro(),
                medicamentoService.getNomeByNroRegistro(estoque.getNroRegistro()),
                estoque.getQuantidade(),
                estoque.getDataAtualizacao()))
            .collect(Collectors.toList()));
  }

  public boolean existsByCnpj(Long cnpj) {
    return farmaciaService.existsByCnpj(cnpj);
  }

  public boolean existsByNroRegistro(Integer nroRegistro) {
    return medicamentoService.existsByNroRegistro(nroRegistro);
  }

  public Estoque updateEstoque(EstoqueRequest estoqueRequest) throws CnpjFoundException, NroRegistroFoundException {
    if (!existsByCnpj(estoqueRequest.getCnpj())) {
      throw new CnpjFoundException("CNPJ não encontrado.");
    }

    if (!existsByNroRegistro(estoqueRequest.getNroRegistro())) {
      throw new NroRegistroFoundException("Número de Registro não encontrado");
    }

    Estoque estoqueEncontrado = estoqueRepository.findEstoqueByCnpjAndNroRegistro(estoqueRequest.getCnpj(), estoqueRequest.getNroRegistro());

    if (Objects.isNull(estoqueEncontrado)) {
      Estoque estoqueNovo = mapper.map(estoqueRequest, Estoque.class);

      return estoqueRepository.save(estoqueNovo);
    }

    estoqueEncontrado.setQuantidade(estoqueEncontrado.getQuantidade() + estoqueRequest.getQuantidade());

    return estoqueRepository.save(estoqueEncontrado);
  }


  public Estoque decreaseEstoque(EstoqueRequest estoqueRequest) throws CnpjFoundException, NroRegistroFoundException, QuantidadeMaiorException {
    if (!existsByCnpj(estoqueRequest.getCnpj())) {
      throw new CnpjFoundException("CNPJ não encontrado.");
    }

    if (!existsByNroRegistro(estoqueRequest.getNroRegistro())) {
      throw new NroRegistroFoundException("Número de Registro não encontrado");
    }

    Estoque estoqueEncontrado = estoqueRepository.findEstoqueByCnpjAndNroRegistro(estoqueRequest.getCnpj(), estoqueRequest.getNroRegistro());

    if (estoqueRequest.getQuantidade() > estoqueEncontrado.getQuantidade()) {
      throw new QuantidadeMaiorException(String.format("Quantidade de produtos maior que o saldo atual: %d.", estoqueEncontrado.getQuantidade()));
    }

    estoqueEncontrado.setQuantidade(estoqueEncontrado.getQuantidade() - estoqueRequest.getQuantidade());

    return estoqueRepository.save(estoqueEncontrado);
  }

  public List<Estoque> trocaEstoque(EstoqueTrocaRequest estoqueTrocaRequest) throws CnpjFoundException, NroRegistroFoundException, QuantidadeMaiorException {
    if (!existsByCnpj(estoqueTrocaRequest.getCnpjOrigem())) {
      throw new CnpjFoundException("CNPJ de origem não encontrado.");
    }

    if (!existsByCnpj(estoqueTrocaRequest.getCnpjDestino())) {
      throw new CnpjFoundException("CNPJ destino não encontrado.");
    }

    if (!existsByNroRegistro(estoqueTrocaRequest.getNroRegistro())) {
      throw new NroRegistroFoundException("Número de Registro não encontrado");
    }

    Estoque estoqueOrigem = estoqueRepository.findEstoqueByCnpjAndNroRegistro(estoqueTrocaRequest.getCnpjOrigem(), estoqueTrocaRequest.getNroRegistro());

    Estoque estoqueDestino = estoqueRepository.findEstoqueByCnpjAndNroRegistro(estoqueTrocaRequest.getCnpjDestino(), estoqueTrocaRequest.getNroRegistro());

    if (Objects.isNull(estoqueDestino)) {
      Estoque estoqueNovo = new Estoque(estoqueTrocaRequest.getCnpjDestino(), estoqueTrocaRequest.getNroRegistro(), 0, LocalDateTime.now());
      estoqueDestino = estoqueRepository.save(estoqueNovo);
    }

    if (estoqueTrocaRequest.getQuantidade() > estoqueOrigem.getQuantidade()) {
      throw new QuantidadeMaiorException(String.format("Quantidade de produtos na origem é insuficiente. O saldo atual é: %d.", estoqueOrigem.getQuantidade()));
    }

    estoqueOrigem.setQuantidade(estoqueOrigem.getQuantidade() - estoqueTrocaRequest.getQuantidade());

    estoqueDestino.setQuantidade(estoqueDestino.getQuantidade() + estoqueTrocaRequest.getQuantidade());

    return List.of(estoqueRepository.save(estoqueOrigem), estoqueRepository.save(estoqueDestino));

  }

}

