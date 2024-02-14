package web.medicine.cliniqueapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.medicine.cliniqueapp.entities.RendezVous;

public interface RendesVousRepository extends JpaRepository<RendezVous,Long> {
}
