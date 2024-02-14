package web.medicine.cliniqueapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import web.medicine.cliniqueapp.entities.*;
import web.medicine.cliniqueapp.repositories.ConsultationRepository;
import web.medicine.cliniqueapp.repositories.MedecinRepository;
import web.medicine.cliniqueapp.repositories.PatientRepository;
import web.medicine.cliniqueapp.repositories.RendesVousRepository;
import web.medicine.cliniqueapp.service.IHospitalService;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class CliniqueAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueAppApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService){
		return args ->{
			Stream.of("habiba","hassin","mohamed")
					.forEach(name ->{
						Medecin med=new Medecin();
						med.setName(name);
						med.setEmail(name +"@gmail.com");
						med.setSpecialty(Math.random()>0.5?"cardio":"ophtalmo");
						hospitalService.saveMedecin(med);
					});

			Stream.of("kamel","zahra","ilef","iline")
					.forEach(name ->{
						Patient pat=new Patient();
						pat.setNAME(name);
						pat.setEmail(name +"@gmail.com");
						hospitalService.savePatient(pat);
					});

			Patient patient=hospitalService.cherchPatId(3L);
			Medecin medecin=hospitalService.cherchMedId(2L);
			// Patient patient =patientRepository.findById(2L).get();
			// Medecin medecin=medecinRepository.findById(3L).orElse(null);

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDateRndezVous(new Date(122, Calendar.APRIL,13));
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			rendezVous.setStatus(Status.PENDED);
			hospitalService.saveRendezVous(rendezVous);

			//RendezVous rendezVous1 = rendesVousRepository.findById(1L).get();
			RendezVous rendezVous1=hospitalService.cherchRendezvousId(1L);

			Consultation consultation=new Consultation();
			consultation.setDateConsltation(new Date(2022,11,13));
			consultation.setPrixConsultation(50);
			consultation.setRapportConsulation("voici le rapport");
			consultation.setRendezVous(rendezVous1);
			hospitalService.saveConsultation(consultation);
			/*
			Medecin m =medecinRepository.findById(1L).get();
			System.out.println(m.getEmail());

			Medecin me=hospitalService.chercherMedecin("hassin");
			System.out.println("lid de medecin est " +me.getId());
			*/
		};
	}
}
