package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;

@Entity
@Table(name = "MEDICAMENTOS")
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
