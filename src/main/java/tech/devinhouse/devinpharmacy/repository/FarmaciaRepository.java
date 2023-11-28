package tech.devinhouse.devinpharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharmacy.models.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}
