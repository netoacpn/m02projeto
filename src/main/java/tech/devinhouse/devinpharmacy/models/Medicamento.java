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
  @Column(nullable = false)
  private Integer nroRegistro;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String laboratorio;
  @Column(nullable = false)
  private String dosagem;
  @Column
  private String descricao;
  @Column(nullable = false)
  private Float preco;
  @Enumerated(EnumType.STRING)
  private TipoMedicamento tipo;

  @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
  private Set<Estoque> estoques;

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
