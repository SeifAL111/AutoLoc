package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/Vehicule")
@RequiredArgsConstructor
@Tag(name = "Gestion des Véhicules", description = "Endpoints pour la gestion des véhicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Récupérer la liste de tous les véhicules", description = "Permet d'afficher l'ensemble des véhicules enregistrés en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par son ID", description = "Recherche et renvoie un véhicule spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Véhicule trouvé avec succès")
    @GetMapping("/retrieve-vehicule/{id-vehicule}")
    public Vehicule retrieveVehicule(@PathVariable("id-vehicule") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @Operation(summary = "Ajouter un nouveau véhicule", description = "Enregistre un nouveau véhicule dans le système.")
    @ApiResponse(responseCode = "200", description = "Véhicule ajouté avec succès")
    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @Operation(summary = "Mettre à jour un véhicule", description = "Modifie les informations d'un véhicule existant.")
    @ApiResponse(responseCode = "200", description = "Véhicule mis à jour avec succès")
    @PutMapping("/update-vehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Véhicule supprimé avec succès")
    @DeleteMapping("/remove-vehicule/{id-vehicule}")
    public void removeVehicule(@PathVariable("id-vehicule") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }
}