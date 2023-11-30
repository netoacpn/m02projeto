package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

  @NonNull
  private Integer quantidade;
  @NonNull
  private LocalDateTime dataAtualizacao;


  public Estoque(Farmacia farmacia, Medicamento medicamento, Integer quantidade, LocalDateTime dataAtualizacao) {
    this.id = new EstoqueId(farmacia.getCnpj(), medicamento.getNroRegistro());
    this.farmacia = farmacia;
    this.medicamento = medicamento;
    this.quantidade = quantidade;
    this.dataAtualizacao = dataAtualizacao;
  }

}
