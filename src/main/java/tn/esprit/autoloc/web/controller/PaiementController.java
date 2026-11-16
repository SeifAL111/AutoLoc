package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/Paiement")
@RequiredArgsConstructor
@Tag(name = "Gestion des Paiements", description = "Endpoints pour la gestion des paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @Operation(summary = "Récupérer tous les paiements", description = "Permet d'afficher la liste de tous les paiements enregistrés.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @Operation(summary = "Récupérer un paiement par ID", description = "Recherche et renvoie un paiement spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Paiement trouvé avec succès")
    @GetMapping("/retrieve-paiement/{id-paiement}")
    public Paiement retrievePaiement(@PathVariable("id-paiement") Long idPaiement) {
        return paiementService.retrievePaiement(idPaiement);
    }

    @Operation(summary = "Ajouter un paiement", description = "Enregistre un nouveau paiement dans le système.")
    @ApiResponse(responseCode = "200", description = "Paiement ajouté avec succès")
    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @Operation(summary = "Ajouter plusieurs paiements en lot", description = "Permet d'ajouter une liste de paiements simultanément.")
    @ApiResponse(responseCode = "200", description = "Paiements ajoutés avec succès")
    @PostMapping("/add-paiements")
    public List<Paiement> addPaiements(@RequestBody List<Paiement> paiements) {
        return paiementService.addPaiements(paiements);
    }

    @Operation(summary = "Mettre à jour un paiement", description = "Modifie les informations d'un paiement existant.")
    @ApiResponse(responseCode = "200", description = "Paiement mis à jour avec succès")
    @PutMapping("/update-paiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    @Operation(summary = "Supprimer un paiement", description = "Supprime un paiement de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Paiement supprimé avec succès")
    @DeleteMapping("/remove-paiement/{id-paiement}")
    public void removePaiement(@PathVariable("id-paiement") Long idPaiement) {
        paiementService.removePaiement(idPaiement);
    }
}