package tech.devinhouse.devinpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharmacy.dto.EstoqueResponse;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.repository.EstoqueRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EstoqueService {

  @Autowired
  private EstoqueRepository estoqueRepository;

  @Autowired
  private MedicamentoService medicamentoService;

  public Estoque saveEstoque(Estoque estoque){
    return estoqueRepository.save(estoque);
  }

  public Optional<List<EstoqueResponse>> getEstoqueByCnpj(Long cnpj) {

    Optional<List<Estoque>> estoques = estoqueRepository.findByCnpj(cnpj);

    return estoques.map(estoqueList ->
        estoqueList.stream()
            .map(estoque -> new EstoqueResponse(
                estoque.getNroRegistro(),
                medicamentoService.getNomeByNroRegistro(estoque.getNroRegistro()),
                estoque.getQuantidade(),
                estoque.getDataAtualizacao()))
            .collect(Collectors.toList()));
  }
}

