package tech.devinhouse.devinpharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmaciaResponse {
  private Long cnpj;
  private String razaoSocial;
  private String nomeFantasia;
  private String email;
  private String telefone;
  private String celular;
  private EnderecoResponse endereco;

}



