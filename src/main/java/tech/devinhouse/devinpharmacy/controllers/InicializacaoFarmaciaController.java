package tech.devinhouse.devinpharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharmacy.enums.TipoMedicamento;
import tech.devinhouse.devinpharmacy.models.Endereco;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.models.Farmacia;
import tech.devinhouse.devinpharmacy.models.Medicamento;
import tech.devinhouse.devinpharmacy.services.EstoqueService;
import tech.devinhouse.devinpharmacy.services.FarmaciaService;
import tech.devinhouse.devinpharmacy.services.MedicamentoService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/inicializacao")
public class InicializacaoFarmaciaController {

  @Autowired
  private FarmaciaService farmaciaService;
  @Autowired
  private MedicamentoService medicamentoService;
  @Autowired
  private EstoqueService estoqueService;


  @PostMapping
  public ResponseEntity<?> saveDados(){

    Endereco endereco1 = new Endereco(88888999L, "Rua Porto Real", 67, "Westeros", "Berlim", "SC", 15.23456, 2.8678687);
    Farmacia farmacia1 = new Farmacia(90561736000121L, "DevMed Ltda", "Farmácia DevMed", "devmed@farmacia.com", "(44)4444-4444", "(44)9444-4441", endereco1);
    farmaciaService.saveFarmacia(farmacia1);

    Endereco endereco2 = new Endereco(8877799L,"Rua Madrid", 76, "Winterfell", "Estocolmo", "SC", 19.254356, 3.8987687);
    Farmacia farmacia2 = new Farmacia(43178995000198L, "MedHouse Ltda", "Farmácia MedHouse", "medhouse@farmacia.com", "(55)5555-5555", "(45)95555-5555", endereco2);
    farmaciaService.saveFarmacia(farmacia2);


    Medicamento medicamento1 = new Medicamento(1010, "Programapan", "Matrix", "2x ao dia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunmc eleifend", 111.00f, TipoMedicamento.COMUM);
    medicamentoService.saveMedicamento(medicamento1);
    Medicamento medicamento2 = new Medicamento(7473, "Cafex", "Colombia Farm", "4x ao dia", "Pellentesque non ultricies mauris, ut lobortis elit. Cras nec cursus nibh", 51.50f, TipoMedicamento.COMUM);
    medicamentoService.saveMedicamento(medicamento2);
    Medicamento medicamento3 = new Medicamento(2233, "Estomazol", "Acme", "1x ao dia", "Sed risus mauris, consectetur eget egestas vitae", 22.50f, TipoMedicamento.COMUM);
    medicamentoService.saveMedicamento(medicamento3);
    Medicamento medicamento4 = new Medicamento(8880, "Gelox", "Ice", "2x ao dia", "Quisque quam orci, vulputate sit amet", 11.50f, TipoMedicamento.COMUM);
    medicamentoService.saveMedicamento(medicamento4);
    Medicamento medicamento5 = new Medicamento(5656, "Aspirazol", "Acme", "3x ao dia", "Sed faucibus, libero iaculis pulvinar consequat, augue elit eleifend", 10.50f, TipoMedicamento.CONTROLADO);
    medicamentoService.saveMedicamento(medicamento5);
    Medicamento medicamento6 = new Medicamento(4040, "Propolizol", "Bee", "5x ao dia", "Nunc euismod ipsum purus, sit amet finibus libero ultricies in", 10.50f, TipoMedicamento.CONTROLADO);
    medicamentoService.saveMedicamento(medicamento6);


    Estoque estoque1 = new Estoque(farmacia1, medicamento1, 12, LocalDateTime.now());
    estoqueService.saveEstoque(estoque1);
    Estoque estoque2 = new Estoque(farmacia1, medicamento2, 10, LocalDateTime.now());
    estoqueService.saveEstoque(estoque2);
    Estoque estoque3 = new Estoque(farmacia2, medicamento2, 2, LocalDateTime.now());
    estoqueService.saveEstoque(estoque3);
    Estoque estoque4 = new Estoque(farmacia2, medicamento3, 15, LocalDateTime.now());
    estoqueService.saveEstoque(estoque4);
    Estoque estoque5 = new Estoque(farmacia2, medicamento4, 16, LocalDateTime.now());
    estoqueService.saveEstoque(estoque5);
    Estoque estoque6 = new Estoque(farmacia2, medicamento6, 22, LocalDateTime.now());
    estoqueService.saveEstoque(estoque6);



    return new ResponseEntity<>(HttpStatus.OK);
  }
}
