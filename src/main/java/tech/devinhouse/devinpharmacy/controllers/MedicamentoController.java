package tech.devinhouse.devinpharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharmacy.models.Medicamento;
import tech.devinhouse.devinpharmacy.services.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

  @Autowired
  private MedicamentoService medicamentoService;

  @GetMapping
  public ResponseEntity<?> getAllMedicamentos(){
    List<Medicamento> medicamentos = medicamentoService.getAllMedicamento();
    if (medicamentos.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há medicamentos cadastrados.");
    } else {
      return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }
  }
}
