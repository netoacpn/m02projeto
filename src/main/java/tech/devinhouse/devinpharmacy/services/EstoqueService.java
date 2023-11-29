package tech.devinhouse.devinpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.models.EstoqueId;
import tech.devinhouse.devinpharmacy.repository.EstoqueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

  @Autowired
  EstoqueRepository estoqueRepository;

  public Estoque saveEstoque(Estoque estoque){
    return estoqueRepository.save(estoque);
  }

  public Optional<Estoque> getEstoqueById(EstoqueId estoqueId){
    return estoqueRepository.findById(estoqueId);
  }

  public List<Estoque> getAllEstoque(){
    return estoqueRepository.findAll();
  }

  public void deleteEstoque(EstoqueId estoqueId){
    estoqueRepository.deleteById(estoqueId);
  }
}
