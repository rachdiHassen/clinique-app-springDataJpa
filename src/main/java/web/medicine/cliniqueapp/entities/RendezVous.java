package web.medicine.cliniqueapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Temporal(TemporalType.DATE)
    private Date dateRndezVous;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private  Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consulation;
}
