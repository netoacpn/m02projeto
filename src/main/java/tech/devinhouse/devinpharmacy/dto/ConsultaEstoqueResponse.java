package tech.devinhouse.devinpharmacy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsultaEstoqueResponse {

  private Integer nroRegistro;

  private String nome;

  private Integer quantidade;

  private LocalDateTime dataAtualizacao;
}
