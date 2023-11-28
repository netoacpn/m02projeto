package tech.devinhouse.devinpharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharmacy.models.Estoque;

@Repository
public interface EstoqueMedicamentoRepository extends JpaRepository<Estoque, Integer> {
}
