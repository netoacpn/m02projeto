package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "FARMACIAS")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Farmacia {
  @Id
  private Long cnpj;
  private String razaoSocial;
  private String nomeFantasia;
  private String email;
  private String telefone;
  private String celular;
  @Embedded
  private Endereco endereco;
}
