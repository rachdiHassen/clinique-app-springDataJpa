package web.medicine.cliniqueapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id
    private String ID;
    private Date dateConsltation;
    private String rapportConsulation;
    private double prixConsultation;
    @OneToOne
    private RendezVous rendezVous;
}
