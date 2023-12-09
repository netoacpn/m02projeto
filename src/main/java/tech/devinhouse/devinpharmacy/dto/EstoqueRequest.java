package tech.devinhouse.devinpharmacy.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstoqueRequest {

  @NotNull(message = "O CNPJ é obrigatório.")
  private Long cnpj;

  @NotNull(message = "O Número de Registro é obrigatório.")
  private Integer nroRegistro;

  @NotNull(message = "A quantidade é obrigatória.")
  @Positive(message = "O valor deve ser positivo.")
  @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "A quantidade deve ser um número inteiro.")
  private Integer quantidade;

  private LocalDateTime dataAtualizacao = LocalDateTime.now();
}
