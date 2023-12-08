package tech.devinhouse.devinpharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharmacy.dto.EstoqueResponse;
import tech.devinhouse.devinpharmacy.services.EstoqueService;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/estoques")
public class EstoqueController {

  @Autowired
  private EstoqueService estoqueService;


  @GetMapping("/{cnpj}")
  public ResponseEntity<?> getEstoqueByCnpj(@PathVariable ("cnpj") Long cnpj){
    Optional<List<EstoqueResponse>> estoques = estoqueService.getEstoqueByCnpj(cnpj);

    return ResponseEntity.status(HttpStatus.OK).body(estoques.orElse(Collections.emptyList()));
  }
}
