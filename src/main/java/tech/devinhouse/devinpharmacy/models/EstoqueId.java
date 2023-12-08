package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueId implements Serializable {
  private Long cnpj;
  private Integer nroRegistro;
}
