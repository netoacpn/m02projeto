package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEDICAMENTOS")
@Data
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
}
