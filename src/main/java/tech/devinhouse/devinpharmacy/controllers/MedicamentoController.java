package tech.devinhouse.devinpharmacy.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharmacy.dto.MedicamentoRequest;
import tech.devinhouse.devinpharmacy.dto.MedicamentoResponse;
import tech.devinhouse.devinpharmacy.exceptions.NroRegistroFoundException;
import tech.devinhouse.devinpharmacy.models.Medicamento;
import tech.devinhouse.devinpharmacy.services.MedicamentoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

  @Autowired
  private MedicamentoService medicamentoService;

  @Autowired
  private ModelMapper mapper;

  @GetMapping
  public ResponseEntity<?> getAllMedicamentos(){
    List<Medicamento> medicamentos = medicamentoService.getAllMedicamento();
    if (medicamentos.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      List<MedicamentoResponse> medicamentosResponses = medicamentos.stream().map(medicamento -> mapper.map(medicamento, MedicamentoResponse.class)).collect(Collectors.toList());
      return new ResponseEntity<>(medicamentosResponses, HttpStatus.OK);
    }
  }

  @GetMapping("/{nroRegistro}")
  public ResponseEntity<?> getMedicamentoById(@PathVariable Integer nroRegistro){
    Optional<Medicamento> medicamento = medicamentoService.getMedicamentoById(nroRegistro);

    if (medicamento.isPresent()){
      MedicamentoResponse response = mapper.map(medicamento.get(), MedicamentoResponse.class);
      return ResponseEntity.ok(response);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<?> saveMedicamento(@Valid @RequestBody MedicamentoRequest medicamentoRequest) throws NroRegistroFoundException {
    if (medicamentoService.existByNroRegistro(medicamentoRequest.getNroRegistro())){
      throw new NroRegistroFoundException("Número de Registro já cadastrado.");
    }

    Medicamento medicamento = mapper.map(medicamentoRequest, Medicamento.class);
    medicamento = medicamentoService.saveMedicamento(medicamento);

    MedicamentoResponse response = mapper.map(medicamento, MedicamentoResponse.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

}
