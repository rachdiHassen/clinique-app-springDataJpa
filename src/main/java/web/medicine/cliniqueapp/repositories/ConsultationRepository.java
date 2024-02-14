package web.medicine.cliniqueapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.medicine.cliniqueapp.entities.Consultation;

public interface ConsultationRepository extends JpaRepository <Consultation, Long>{
}
