package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "FARMACIAS")
@Data
public class Farmacia {
  @Id
  @Column(nullable = false)
  private Long cnpj;
  @Column(nullable = false)
  private String razaoSocial;
  @Column(nullable = false)
  private String nomeFantasia;
  @Column(nullable = false)
  private String email;
  @Column
  private String telefone;
  @Column(nullable = false)
  private String celular;
  @Embedded
  private Endereco endereco;

  @OneToMany(mappedBy = "farmacia", cascade = CascadeType.ALL)
  private Set<Estoque> estoques;
}
