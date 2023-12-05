package tech.devinhouse.devinpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharmacy.models.Farmacia;
import tech.devinhouse.devinpharmacy.repository.FarmaciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FarmaciaService {

  @Autowired
  FarmaciaRepository farmaciaRepository;

  public Farmacia saveFarmacia(Farmacia farmacia){
    return farmaciaRepository.save(farmacia);
  }

  public Optional<Farmacia> getFarmaciaById(Long cnpj){
    return farmaciaRepository.findById(cnpj);
  }

  public List<Farmacia> getAllFarmacia(){
    return farmaciaRepository.findAll();
  }

  public void deleteFarmacia(Long cnpj){
    farmaciaRepository.deleteById(cnpj);
  }

  public boolean existsByCnpj(Long cnpj) {
    return farmaciaRepository.existsByCnpj(cnpj);
  }
}
