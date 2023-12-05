package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
  private Long cep;
  private String logradouro;
  private Integer numero;
  private String bairro;
  private String cidade;
  private String estado;
  private String complemento;
  private Double latitude;
  private Double longitude;

  public Endereco(Long cep, String logradouro, Integer numero, String bairro, String cidade, String estado, Double latitude, Double longitude) {
    this.cep = cep;
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
