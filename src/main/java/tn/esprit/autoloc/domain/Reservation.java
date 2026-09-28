package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Plusieurs réservations appartiennent à un client
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    // Plusieurs réservations concernent un véhicule
    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;

    // Une réservation donne lieu à un seul contrat
    @OneToOne(mappedBy = "reservation")
    private Contrat contrat;
}