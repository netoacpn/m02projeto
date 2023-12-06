package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import tech.devinhouse.devinpharmacy.dto.FarmaciaRequest;
import tech.devinhouse.devinpharmacy.dto.FarmaciaResponse;

import java.util.Set;

@Entity
@Table(name = "FARMACIAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

  public Farmacia(FarmaciaRequest farmacia) {
    this.cnpj = getCnpj();
    this.razaoSocial = getRazaoSocial();
    this.nomeFantasia = getNomeFantasia();
    this.email = getEmail();
    this.telefone = getTelefone();
    this.celular = getCelular();
    this.endereco = getEndereco();
  }


}
