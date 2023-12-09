package tech.devinhouse.devinpharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CompraEstoqueResponse {

  private Long cnpj;

  private Integer nroRegistro;

  private Integer quantidade;

  private LocalDateTime dataAtualizacao;
}
