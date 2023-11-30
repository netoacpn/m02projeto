package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "ESTOQUES")
@Data
@NoArgsConstructor
@AllArgsConstructor
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


  public Estoque(Farmacia farmacia, Medicamento medicamento, Integer quantidade, LocalDateTime dataAtualizacao) {
    this.farmacia = farmacia;
    this.medicamento = medicamento;
    this.quantidade = quantidade;
    this.dataAtualizacao = dataAtualizacao;
  }

}
