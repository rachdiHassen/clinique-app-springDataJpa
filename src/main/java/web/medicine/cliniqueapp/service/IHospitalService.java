package web.medicine.cliniqueapp.service;

import web.medicine.cliniqueapp.entities.Consultation;
import web.medicine.cliniqueapp.entities.Medecin;
import web.medicine.cliniqueapp.entities.Patient;
import web.medicine.cliniqueapp.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous (RendezVous rendezVous);
    Consultation saveConsultation (Consultation consultation);

    Medecin chercherMedecin(String nom);
    Patient cherchPatId(Long x);
    Medecin cherchMedId(Long x);
    RendezVous cherchRendezvousId(Long x);

}
