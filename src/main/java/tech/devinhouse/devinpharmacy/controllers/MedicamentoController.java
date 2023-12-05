package tech.devinhouse.devinpharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharmacy.models.Medicamento;
import tech.devinhouse.devinpharmacy.services.MedicamentoService;

import javax.validation.Valid;
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

  @PostMapping
  public ResponseEntity<?> saveMedicamento(@RequestBody @Valid Medicamento medicamento){
    if (medicamentoService.existByNroRegistro(medicamento.getNroRegistro())){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado.");
    }

    medicamentoService.saveMedicamento(medicamento);
    return ResponseEntity.status(HttpStatus.CREATED).body(medicamento);
  }


}
