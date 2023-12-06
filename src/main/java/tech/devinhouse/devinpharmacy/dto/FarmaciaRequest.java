package tech.devinhouse.devinpharmacy.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FarmaciaRequest {

  @NotNull(message = "O CNPJ é obrigatório.")
  private Long cnpj;

  @NotBlank(message = "Razão Social é obrigatória.")
  @NotNull(message = "Razão Social é obrigatória.")
  private String razaoSocial;

  @NotBlank(message = "Nome Fantasia é obrigatório.")
  @NotNull(message = "Nome Fantasia é obrigatório.")
  private String nomeFantasia;

  @NotBlank(message = "E-mail é obrigatório.")
  @NotNull(message = "E-mail é obrigatório.")
  private String email;

  private String telefone;

  @NotBlank(message = "Celular é obrigatório.")
  @NotNull(message = "Celular é obrigatório.")
  private String celular;

  @Valid
  @NotNull(message = "Endereço é obrigatório.")
  private EnderecoRequest endereco;
}


