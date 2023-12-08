package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;

import java.util.Set;

@Entity
@Table(name = "MEDICAMENTOS")
@Data
@NoArgsConstructor
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


  public Medicamento(Integer nroRegistro, String nome, String laboratorio, String dosagem, String descricao, Float preco, TipoMedicamento tipo) {
    this.nroRegistro = nroRegistro;
    this.nome = nome;
    this.laboratorio = laboratorio;
    this.dosagem = dosagem;
    this.descricao = descricao;
    this.preco = preco;
    this.tipo = tipo;
  }
}
