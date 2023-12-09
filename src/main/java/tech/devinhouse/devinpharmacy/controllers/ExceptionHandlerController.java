package tech.devinhouse.devinpharmacy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.devinhouse.devinpharmacy.dto.ErrorDto;
import tech.devinhouse.devinpharmacy.exceptions.CnpjFoundException;
import tech.devinhouse.devinpharmacy.exceptions.NroRegistroFoundException;
import tech.devinhouse.devinpharmacy.exceptions.QuantidadeMaiorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

  @ExceptionHandler(CnpjFoundException.class)
  public ResponseEntity<?> cnpjNotFoundException(CnpjFoundException exception) {
    return new ResponseEntity<>(
        buildErrorDto(exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NroRegistroFoundException.class)
  public ResponseEntity<?> nroRegistroFoundException(NroRegistroFoundException exception) {
    return new ResponseEntity<>(
        buildErrorDto(exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
    return new ResponseEntity<>(
        buildErrorDto(exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(QuantidadeMaiorException.class)
  public ResponseEntity<?> methodArgumentNotValidException(QuantidadeMaiorException exception) {
    return new ResponseEntity<>(
        buildErrorDto(exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }


  private ErrorDto buildErrorDto(String message) {
    return ErrorDto.builder()
        .message(message)
        .timestamp(LocalDateTime.now())
        .build();
  }
}
