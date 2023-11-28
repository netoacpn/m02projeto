package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ESTOQUES")
@IdClass(IdEstoque.class)
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Estoque {
  @Id
  private Long cnpj;
  @Id
  private Integer nroRegistro;
  private Integer quantidade;
  private LocalDateTime dataAtualizacao;
}
