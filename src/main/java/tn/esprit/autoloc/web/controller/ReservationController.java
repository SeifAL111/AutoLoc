package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Reservation")
@RequiredArgsConstructor
@Tag(name = "Gestion des Réservations", description = "Endpoints pour la gestion des réservations")
public class ReservationController {

    private final IReservationService reservationService;

    @Operation(summary = "Récupérer toutes les réservations", description = "Permet d'afficher la liste de toutes les réservations enregistrées.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @Operation(summary = "Récupérer une réservation par ID", description = "Recherche et renvoie une réservation spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Réservation trouvée avec succès")
    @GetMapping("/retrieve-reservation/{id-reservation}")
    public Reservation retrieveReservation(@PathVariable("id-reservation") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    @Operation(summary = "Ajouter une réservation", description = "Enregistre une nouvelle réservation dans le système.")
    @ApiResponse(responseCode = "200", description = "Réservation ajoutée avec succès")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @Operation(summary = "Ajouter plusieurs réservations en lot", description = "Permet d'ajouter une liste de réservations simultanément.")
    @ApiResponse(responseCode = "200", description = "Réservations ajoutées avec succès")
    @PostMapping("/add-reservations")
    public List<Reservation> addReservations(@RequestBody List<Reservation> reservations) {
        return reservationService.addReservations(reservations);
    }

    @Operation(summary = "Mettre à jour une réservation", description = "Modifie les informations d'une réservation existante.")
    @ApiResponse(responseCode = "200", description = "Réservation mise à jour avec succès")
    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @Operation(summary = "Supprimer une réservation", description = "Supprime une réservation de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Réservation supprimée avec succès")
    @DeleteMapping("/remove-reservation/{id-reservation}")
    public void removeReservation(@PathVariable("id-reservation") Long idReservation) {
        reservationService.removeReservation(idReservation);
    }

    @Operation(summary = "Rechercher des réservations par date de début", description = "Permet de récupérer les réservations dont la date de début est postérieure à une date donnée.")
    @ApiResponse(responseCode = "200", description = "Liste des réservations récupérée avec succès")
    @GetMapping("/search-date-after/{date}")
    public List<Reservation> getReservationsApresDate(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return reservationService.getReservationsApresDate(date);
    }
}