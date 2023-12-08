package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import tech.devinhouse.devinpharmacy.dto.FarmaciaRequest;
import tech.devinhouse.devinpharmacy.dto.FarmaciaResponse;

import java.util.Set;

@Entity
@Table(name = "FARMACIAS")
@NoArgsConstructor
@AllArgsConstructor
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
