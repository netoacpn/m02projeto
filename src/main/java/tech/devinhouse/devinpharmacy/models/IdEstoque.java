package tech.devinhouse.devinpharmacy.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class IdEstoque {
  private Long cnpj;
  private Integer nroRegistro;
}
