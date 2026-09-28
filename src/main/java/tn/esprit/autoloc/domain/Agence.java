package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String adresse;

    // Une agence possède plusieurs véhicules
    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules;

    // Une agence emploie plusieurs personnes
    @OneToMany(mappedBy = "agence")
    private List<Employe> employes;
}