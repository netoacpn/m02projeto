package tech.devinhouse.devinpharmacy.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tech.devinhouse.devinpharmacy.models.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
  @NotNull(message = "O CEP é obrigatório.")
  @Pattern(regexp = "\\d{8}", message = "CEP deve conter apenas dígitos e ter 8 caracteres")
  private Long cep;
  @NotBlank(message = "O Logradouro é obrigatório.")
  private String logradouro;
  @NotBlank(message = "O número é obrigatório.")
  private Integer numero;
  @NotBlank(message = "O Bairro é obrigatório.")
  private String bairro;
  @NotBlank(message = "O múnicípio é obrigatório.")
  private String cidade;
  @NotBlank(message = "O Estado é obrigatório.")
  private String estado;
  private String complemento;
  @NotBlank(message = "A Latitude é obrigatória.")
  private Double latitude;
  @NotBlank(message = "A Longitude é obrigatória.")
  private Double longitude;

}
