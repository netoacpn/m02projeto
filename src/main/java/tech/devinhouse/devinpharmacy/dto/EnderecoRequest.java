package tech.devinhouse.devinpharmacy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {

  @NotNull(message = "O CEP é obrigatório.")
  private Long cep;

  @NotBlank(message = "O Logradouro é obrigatório.")
  @NotNull(message = "O Logradouro é obrigatório.")
  private String logradouro;

  @NotNull(message = "O número é obrigatório.")
  private Integer numero;

  @NotBlank(message = "O Bairro é obrigatório.")
  @NotNull(message = "O Bairro é obrigatório.")
  private String bairro;

  @NotBlank(message = "O múnicípio é obrigatório.")
  @NotNull(message = "O múnicípio é obrigatório.")
  private String cidade;

  @NotBlank(message = "O Estado é obrigatório.")
  @NotNull(message = "O Estado é obrigatório.")
  private String estado;

  private String complemento;

  @NotNull(message = "A Latitude é obrigatória.")
  private Double latitude;

  @NotNull(message = "A Longitude é obrigatória.")
  private Double longitude;

}

