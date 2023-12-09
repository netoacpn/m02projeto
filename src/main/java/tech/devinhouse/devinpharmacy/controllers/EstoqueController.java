package tech.devinhouse.devinpharmacy.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharmacy.dto.EstoqueRequest;
import tech.devinhouse.devinpharmacy.dto.ConsultaEstoqueResponse;
import tech.devinhouse.devinpharmacy.dto.EstoqueTrocaRequest;
import tech.devinhouse.devinpharmacy.exceptions.CnpjFoundException;
import tech.devinhouse.devinpharmacy.exceptions.NroRegistroFoundException;
import tech.devinhouse.devinpharmacy.exceptions.QuantidadeMaiorException;
import tech.devinhouse.devinpharmacy.services.EstoqueService;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {

  @Autowired
  private EstoqueService estoqueService;

  @Autowired
  private ModelMapper mapper;

  @GetMapping("/{cnpj}")
  public ResponseEntity<?> getEstoqueByCnpj(@PathVariable("cnpj") Long cnpj) {
    Optional<List<ConsultaEstoqueResponse>> estoques = estoqueService.getEstoqueByCnpj(cnpj);

    return ResponseEntity.status(HttpStatus.OK).body(estoques.orElse(Collections.emptyList()));
  }

  @PostMapping
  public ResponseEntity<?> saveEstoque(@Valid @RequestBody EstoqueRequest estoqueRequest) throws CnpjFoundException, NroRegistroFoundException {

    return ResponseEntity.status(HttpStatus.OK).body(estoqueService.updateEstoque(estoqueRequest));
  }

  @DeleteMapping("/delete")
  public ResponseEntity<?> deleteEstoque(@Valid @RequestBody EstoqueRequest estoqueRequest) throws CnpjFoundException, NroRegistroFoundException, QuantidadeMaiorException {

    return ResponseEntity.status(HttpStatus.OK).body(estoqueService.decreaseEstoque(estoqueRequest));
  }

  @PutMapping
  public ResponseEntity<?> trocaEstoque(@Valid @RequestBody EstoqueTrocaRequest estoqueTrocaRequest) throws CnpjFoundException, NroRegistroFoundException, QuantidadeMaiorException{

    return ResponseEntity.status(HttpStatus.OK).body(estoqueService.trocaEstoque(estoqueTrocaRequest));
  }
}
