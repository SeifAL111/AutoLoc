package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/Agence")
@RequiredArgsConstructor
@Tag(name = "Gestion des Agences", description = "Endpoints pour la gestion des agences")
public class AgenceController {

    private final IAgenceService agenceService;

    @Operation(summary = "Récupérer toutes les agences", description = "Permet d'afficher la liste de toutes les agences enregistrées en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-agences")
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @Operation(summary = "Récupérer une agence par ID", description = "Recherche et renvoie une agence spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Agence trouvée avec succès")
    @GetMapping("/retrieve-agence/{id-agence}")
    public Agence retrieveAgence(@PathVariable("id-agence") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @Operation(summary = "Ajouter une agence", description = "Enregistre une nouvelle agence dans le système.")
    @ApiResponse(responseCode = "200", description = "Agence ajoutée avec succès")
    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @Operation(summary = "Ajouter plusieurs agences en lot", description = "Permet d'ajouter une liste d'agences simultanément.")
    @ApiResponse(responseCode = "200", description = "Agences ajoutées avec succès")
    @PostMapping("/add-agences")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }

    @Operation(summary = "Mettre à jour une agence", description = "Modifie les informations d'une agence existante.")
    @ApiResponse(responseCode = "200", description = "Agence mise à jour avec succès")
    @PutMapping("/update-agence")
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    @Operation(summary = "Supprimer une agence", description = "Supprime une agence de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Agence supprimée avec succès")
    @DeleteMapping("/remove-agence/{id-agence}")
    public void removeAgence(@PathVariable("id-agence") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }
}