package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private LocalDate dateContrat;
    private Double montantTotal;

    // Un contrat est lié à une seule réservation
    @OneToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    // Un contrat peut faire l'objet de plusieurs paiements (ex: acompte + solde)
    @OneToMany(mappedBy = "contrat")
    private List<Paiement> paiements;
}