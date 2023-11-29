package tech.devinhouse.devinpharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharmacy.models.Estoque;
import tech.devinhouse.devinpharmacy.models.EstoqueId;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, EstoqueId> {
}
