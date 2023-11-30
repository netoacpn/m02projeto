package tech.devinhouse.devinpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Endereco {
  @NonNull
  private Long cep;
  @NonNull
  private String logradouro;
  @NonNull
  private Integer numero;
  @NonNull
  private String bairro;
  @NonNull
  private String cidade;
  @NonNull
  private String estado;
  private String complemento;
  @NonNull
  private Double latitude;
  @NonNull
  private Double longitude;




}
