package tech.devinhouse.devinpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharmacy.models.Medicamento;
import tech.devinhouse.devinpharmacy.repository.MedicamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

  @Autowired
  MedicamentoRepository medicamentoRepository;

  public Medicamento saveMedicamento(Medicamento medicamento){
    return medicamentoRepository.save(medicamento);
  }

  public Optional<Medicamento> getMedicamentoById(Integer nroRegistro){
    return medicamentoRepository.findById(nroRegistro);
  }

  public List<Medicamento> getAllMedicamento(){
    return medicamentoRepository.findAll();
  }

  public void deleteMedicamento(Integer nroRegistro){
    medicamentoRepository.deleteById(nroRegistro);
  }
}