package web.medicine.cliniqueapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.medicine.cliniqueapp.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByName(String nom);
}
