package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    private Double montant;
    private LocalDate datePaiement;

    // Plusieurs paiements se rapportent à un contrat
    @ManyToOne
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;
}