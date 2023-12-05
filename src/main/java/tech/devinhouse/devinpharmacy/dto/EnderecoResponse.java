package tech.devinhouse.devinpharmacy.dto;

import lombok.Data;

@Data
public class EnderecoResponse {
  private String cep;
  private String logradouro;
  private String numero;
  private String bairro;
  private String cidade;
  private String estado;
  private String complemento;
  private Double latitude;
  private Double longitude;

  public EnderecoResponse(String cep, String logradouro, String numero, String bairro, String cidade, String estado, String complemento, Double latitude, Double longitude) {
    this.cep = cep;
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.complemento = complemento;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
