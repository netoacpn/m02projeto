package tech.devinhouse.devinpharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.devinpharmacy.models.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}
