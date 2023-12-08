package tech.devinhouse.devinpharmacy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharmacy.dto.EstoqueResponse;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.services.EstoqueService;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/estoques")
public class EstoqueController {

  @Autowired
  private EstoqueService estoqueService;

  @Autowired
  private ModelMapper mapper;


  @GetMapping("/{cnpj}")
  public ResponseEntity<?> getEstoqueByCnpj(@PathVariable ("cnpj") Long cnpj){
    Optional<List<Estoque>> estoques = estoqueService.getEstoqueByCnpj(cnpj);

    return ResponseEntity.status(HttpStatus.OK).body(estoques.orElse(Collections.emptyList()));
  }
}

  /*Optional<List<Estoque>> estoques = estoqueService.getEstoqueByCnpj(cnpj);

  Optional<List<EstoqueResponse>> estoqueResponse = Optional.of(estoques.stream().map(estoque -> mapper.map(estoque, EstoqueResponse.class)).collect(Collectors.toList()));

    return ResponseEntity.status(HttpStatus.OK).body(estoqueResponse.orElse(Collections.emptyList()));*/