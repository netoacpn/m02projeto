package tech.devinhouse.devinpharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharmacy.models.Medicamento;

import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
  boolean existsByNroRegistro(Integer nroRegistro);

  Optional<Medicamento> getByNroRegistro(Integer nroRegistro);
}