package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class EstoqueId {
  private Long cnpj;
  private Integer nroRegistro;
}
