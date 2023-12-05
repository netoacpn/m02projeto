package tech.devinhouse.devinpharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharmacy.models.Farmacia;
import tech.devinhouse.devinpharmacy.services.FarmaciaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

  @Autowired
  private FarmaciaService farmaciaService;

  @GetMapping
  public ResponseEntity<?> getAllFarmacias(){
    List<Farmacia> farmacias = farmaciaService.getAllFarmacia();
    if (farmacias.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há farmácias cadastradas.");
    } else {
      return new ResponseEntity<>(farmacias, HttpStatus.OK);
    }
  }

  @GetMapping("/{cnpj}")
  public ResponseEntity<?> getFarmaciaById(@PathVariable Long cnpj){
    Optional<Farmacia> farmacia = farmaciaService.getFarmaciaById(cnpj);
    return farmacia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  // VERIFICAR VALIDAÇÃO
  @PostMapping
  public ResponseEntity<?> saveFarmacia(@RequestBody @Valid Farmacia farmacia){
    if (farmaciaService.existsByCnpj(farmacia.getCnpj())){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado.");
    }

    farmaciaService.saveFarmacia(farmacia);
    return ResponseEntity.status(HttpStatus.CREATED).body(farmacia);
  }

}
