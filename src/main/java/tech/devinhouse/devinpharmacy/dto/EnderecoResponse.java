package tech.devinhouse.devinpharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {
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
