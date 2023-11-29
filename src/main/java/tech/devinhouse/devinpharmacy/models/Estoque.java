package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "ESTOQUES")
@Data
public class Estoque {
  @EmbeddedId
  private EstoqueId id;

  @ManyToOne
  @MapsId("cnpj")
  @JoinColumn(name = "cnpj")
  private Farmacia farmacia;

  @ManyToOne
  @MapsId("nroRegistro")
  @JoinColumn(name = "nro_registro")
  private Medicamento medicamento;

  @Column(nullable = false)
  private Integer quantidade;
  @Column(nullable = false)
  private LocalDateTime dataAtualizacao;

}
