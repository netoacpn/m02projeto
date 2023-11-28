package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;

@Entity
@Table(name = "MEDICAMENTOS")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Medicamento {
  @Id
  private Integer nroRegistro;
  private String nome;
  private String laboratorio;
  private String dosagem;
  private String descricao;
  private Float preco;
  @Enumerated(EnumType.STRING)
  private TipoMedicamento tipo;

}
