package web.medicine.cliniqueapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.medicine.cliniqueapp.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
