package web.medicine.cliniqueapp.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import web.medicine.cliniqueapp.entities.Consultation;
import web.medicine.cliniqueapp.entities.Medecin;
import web.medicine.cliniqueapp.entities.Patient;
import web.medicine.cliniqueapp.entities.RendezVous;
import web.medicine.cliniqueapp.repositories.ConsultationRepository;
import web.medicine.cliniqueapp.repositories.MedecinRepository;
import web.medicine.cliniqueapp.repositories.PatientRepository;
import web.medicine.cliniqueapp.repositories.RendesVousRepository;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService{
    private ConsultationRepository consultationRepository;
   private  MedecinRepository medecinRepository;
    private PatientRepository patientRepository;
    private RendesVousRepository rendesVousRepository;

    public HospitalServiceImpl(ConsultationRepository consultationRepository,
                               MedecinRepository medecinRepository,
                               PatientRepository patientRepository,
                               RendesVousRepository rendesVousRepository) {
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
        this.rendesVousRepository = rendesVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin) ;
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendesVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        consultation.setID(UUID.randomUUID().toString());
        return consultationRepository.save(consultation);
    }

    @Override
    public Medecin chercherMedecin(String nom) {
        return medecinRepository.findByName(nom);
    }

    @Override
    public Patient cherchPatId(Long x) {
        return patientRepository.findById(x).get();
    }

    @Override
    public Medecin cherchMedId(Long x) {
        return medecinRepository.findById(x).get();
    }

    @Override
    public RendezVous cherchRendezvousId(Long x) {
        return rendesVousRepository.findById(x).get();
    }


}
