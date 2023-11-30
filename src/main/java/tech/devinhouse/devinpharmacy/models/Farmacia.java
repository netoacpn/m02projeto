package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "FARMACIAS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Farmacia {
  @Id
  @NonNull
  private Long cnpj;
  @NonNull
  private String razaoSocial;
  @NonNull
  private String nomeFantasia;
  @NonNull
  private String email;
  private String telefone;
  @NonNull
  private String celular;
  @Embedded
  @NonNull
  private Endereco endereco;

  @OneToMany(mappedBy = "farmacia", cascade = CascadeType.ALL)
  private Set<Estoque> estoques;

  public Farmacia(Long cnpj, String razaoSocial, String nomeFantasia, String email, String telefone, String celular, Endereco endereco) {
    this.cnpj = cnpj;
    this.razaoSocial = razaoSocial;
    this.nomeFantasia = nomeFantasia;
    this.email = email;
    this.telefone = telefone;
    this.celular = celular;
    this.endereco = endereco;
  }
}
