package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Data
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
}
