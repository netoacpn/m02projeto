package tech.devinhouse.devinpharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharmacy.models.Farmacia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmaciaRequest {

  @NotNull(message = "O CNPJ é obrigatório.")
  @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter apenas dígitos e ter 14 caracteres")
  private Long cnpj;
  @NotBlank(message = "Razão Social é obrigatória.")
  private String razaoSocial;
  @NotBlank(message = "Nome Fantasia é obrigatório.")
  private String nomeFantasia;
  @NotBlank(message = "E-mail é obrigatório.")
  private String email;
  private String telefone;
  @NotBlank(message = "Celular é obrigatório.")
  private String celular;
  @NotBlank(message = "Endereço é obrigatório.")
  private EnderecoRequest endereco;


  public Farmacia toFarmacia() {
    return new Farmacia(cnpj, razaoSocial, nomeFantasia, email, telefone, celular, endereco.toEndereco());
  }
}
