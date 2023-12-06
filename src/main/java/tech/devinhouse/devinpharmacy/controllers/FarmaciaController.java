package tech.devinhouse.devinpharmacy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharmacy.dto.FarmaciaRequest;
import tech.devinhouse.devinpharmacy.dto.FarmaciaResponse;
import tech.devinhouse.devinpharmacy.models.Farmacia;
import tech.devinhouse.devinpharmacy.services.FarmaciaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

  @Autowired
  private FarmaciaService farmaciaService;

  @Autowired
  private ModelMapper mapper;

  @GetMapping
  public ResponseEntity<?> getAllFarmacias() {
    List<Farmacia> farmacias = farmaciaService.getAllFarmacia();
    if (farmacias.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há farmácias cadastradas.");
    } else {
      List<FarmaciaResponse> farmaciasResponse = farmacias.stream().map(farmacia -> mapper.map(farmacia, FarmaciaResponse.class)).collect(Collectors.toList());
      return new ResponseEntity<>(farmaciasResponse, HttpStatus.OK);
    }
  }

  @GetMapping("/{cnpj}")
  public ResponseEntity<?> getFarmaciaById(@PathVariable Long cnpj) {
    Optional<Farmacia> farmacia = farmaciaService.getFarmaciaById(cnpj);

    if (farmacia.isPresent()) {
      FarmaciaResponse response = mapper.map(farmacia.get(), FarmaciaResponse.class);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farmácia com CNPJ " + cnpj + " não encontrada.");
    }
  }

  @PostMapping
  public ResponseEntity<?> saveFarmacia(@RequestBody @Valid FarmaciaRequest farmaciaRequest) {
    if (farmaciaService.existsByCnpj(farmaciaRequest.getCnpj())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado.");
    }

    Farmacia farmacia = mapper.map(farmaciaRequest, Farmacia.class);
    farmacia = farmaciaService.saveFarmacia(farmacia);

    FarmaciaResponse response = mapper.map(farmacia, FarmaciaResponse.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}

