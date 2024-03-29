package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "ESTOQUES")
@IdClass(EstoqueId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estoque {

  @Id
  private Long cnpj;

  @Id
  private Integer nroRegistro;

  private Integer quantidade;

  private LocalDateTime dataAtualizacao;

}
