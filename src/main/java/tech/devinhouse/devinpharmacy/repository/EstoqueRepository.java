package tech.devinhouse.devinpharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.models.EstoqueId;

import java.util.List;
import java.util.Optional;


@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, EstoqueId> {

  Optional<List<Estoque>> findByCnpj(Long cnpj);

  Estoque findEstoqueByCnpjAndNroRegistro(Long cnpj, Integer nroRegistro);
}
