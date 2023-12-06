package tech.devinhouse.devinpharmacy.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicamentoRequest {

  @NotNull(message = "O número do registro é obrigatório.")
  private Integer nroRegistro;

  @NotBlank(message = "Nome do medicamento é obrigatório.")
  @NotNull(message = "Nome do medicamento é obrigatório.")
  private String nome;

  @NotBlank(message = "O nome do laboratório é obrigatório.")
  @NotNull(message = "O nome do laboratório é obrigatório.")
  private String laboratorio;

  @NotBlank(message = "A dosagem é obrigatória.")
  @NotNull(message = "A dosagem é obrigatória.")
  private String dosagem;

  private String descricao;

  @NotNull(message = "O preço é obrigatório.")
  private Float preco;

  @Valid
  @NotNull(message = "O preço é obrigatório.")
  private TipoMedicamento tipo;
}
