package web.medicine.cliniqueapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String NAME;
    private String email;
    @OneToMany(mappedBy ="patient", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
