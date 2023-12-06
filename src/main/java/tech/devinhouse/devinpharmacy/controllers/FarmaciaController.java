package tech.devinhouse.devinpharmacy.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharmacy.dto.FarmaciaRequest;
import tech.devinhouse.devinpharmacy.dto.FarmaciaResponse;
import tech.devinhouse.devinpharmacy.exceptions.CnpjFoundException;
import tech.devinhouse.devinpharmacy.models.Farmacia;
import tech.devinhouse.devinpharmacy.services.FarmaciaService;


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
      return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      List<FarmaciaResponse> farmaciasResponse = farmacias.stream().map(farmacia -> mapper.map(farmacia, FarmaciaResponse.class)).collect(Collectors.toList());
      return new ResponseEntity<>(farmaciasResponse, HttpStatus.OK);
    }
  }

  @GetMapping("/{cnpj}")
  public ResponseEntity<?> getFarmaciaById(@PathVariable Long cnpj){
    Optional<Farmacia> farmacia = farmaciaService.getFarmaciaById(cnpj);

    if (farmacia.isPresent()) {
      FarmaciaResponse response = mapper.map(farmacia.get(), FarmaciaResponse.class);
      return ResponseEntity.ok(response);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<?> saveFarmacia(@Valid @RequestBody FarmaciaRequest farmaciaRequest) throws CnpjFoundException {
    if (farmaciaService.existsByCnpj(farmaciaRequest.getCnpj())) {
      throw new CnpjFoundException("CNPJ já cadastrado.");
    }

    Farmacia farmacia = mapper.map(farmaciaRequest, Farmacia.class);
    farmacia = farmaciaService.saveFarmacia(farmacia);

    FarmaciaResponse response = mapper.map(farmacia, FarmaciaResponse.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}

