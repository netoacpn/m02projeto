package tech.devinhouse.devinpharmacy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoResponse {
  private Integer nroRegistro;
  private String nome;
  private String laboratorio;
  private String dosagem;
  private String descricao;
  private Float preco;
  private TipoMedicamento tipo;
}
