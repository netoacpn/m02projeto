package tech.devinhouse.devinpharmacy.dto;

import lombok.Data;

@Data
public class FarmaciaResponse {
  private Long id;
  private String cnpj;
  private String razaoSocial;
  private String nomeFantasia;
  private String email;
  private String telefone;
  private String celular;
  private EnderecoResponse endereco;

  public FarmaciaResponse(Long id, String cnpj, String razaoSocial, String nomeFantasia, String email, String telefone, String celular, EnderecoResponse endereco) {
    this.id = id;
    this.cnpj = cnpj;
    this.razaoSocial = razaoSocial;
    this.nomeFantasia = nomeFantasia;
    this.email = email;
    this.telefone = telefone;
    this.celular = celular;
    this.endereco = endereco;
  }
}



