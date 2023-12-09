package tech.devinhouse.devinpharmacy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstoqueTrocaRequest {

  @NotNull(message = "O CNPJ da farmácia de origem é obrigatório.")
  private Long cnpjOrigem;

  @NotNull(message = "O CNPJ da farmácia de destino é obrigatória.")
  private Long cnpjDestino;

  @NotNull(message = "O número de registro do medicamento é obrigatório.")
  private Integer nroRegistro;

  @NotNull(message = "Necessário informar a quantidade.")
  private Integer quantidade;

}
