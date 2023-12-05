package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "FARMACIAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmacia {
  @Id
  @NotNull(message = "O CNPJ é obrigatório.")
  @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter apenas dígitos e ter 14 caracteres")
  private Long cnpj;
  @NotBlank(message = "Razão Social é obrigatória.")
  private String razaoSocial;
  @NotBlank(message = "Nome Fantasia é obrigatório.")
  private String nomeFantasia;
  @NotBlank(message = "E-mail é obrigatório.")
  private String email;
  private String telefone;
  @NotBlank(message = "Celular é obrigatório.")
   private String celular;
  @Embedded
  @NotBlank(message = "Endereço é obrigatório.")
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
