package tech.devinhouse.devinpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharmacy.dto.EstoqueResponse;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.repository.EstoqueRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EstoqueService {

  @Autowired
  private EstoqueRepository estoqueRepository;

  public Estoque saveEstoque(Estoque estoque){
    return estoqueRepository.save(estoque);
  }

  public Optional<List<Estoque>> getEstoqueByCnpj(Long cnpj) {
    return estoqueRepository.findByCnpj(cnpj);
  }


}
