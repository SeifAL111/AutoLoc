package tn.esprit.autoloc.web.controller;

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



    @Operation(summary = "Affecter un véhicule à une agence", description = "Rattache un véhicule neuf ou existant à une agence (ex: Sfax).")
    @ApiResponse(responseCode = "200", description = "Véhicule affecté avec succès")
    @PutMapping("/affecter-vehicule/{id-vehicule}/{id-agence}")
    public Vehicule affecterVehicule(
            @PathVariable("id-vehicule") Long idVehicule,
            @PathVariable("id-agence") Long idAgence) {
        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    @Operation(summary = "Affecter un équipement à un véhicule", description = "Installe un équipement (ex: siège bébé) sur un véhicule.")
    @ApiResponse(responseCode = "200", description = "Équipement affecté au véhicule avec succès")
    @PutMapping("/affecter-equipement/{id-vehicule}/{id-equipement}")
    public Vehicule affecterEquipement(
            @PathVariable("id-vehicule") Long idVehicule,
            @PathVariable("id-equipement") Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @Operation(summary = "Désaffecter un équipement d'un véhicule", description = "Retire un équipement d'un véhicule au retour.")
    @ApiResponse(responseCode = "200", description = "Équipement retiré du véhicule avec succès")
    @PutMapping("/desaffecter-equipement/{id-vehicule}/{id-equipement}")
    public Vehicule desaffecterEquipement(
            @PathVariable("id-vehicule") Long idVehicule,
            @PathVariable("id-equipement") Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }

    @Operation(summary = "Rechercher des véhicules par marque", description = "Permet de filtrer la liste des véhicules selon leur marque.")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping("/search-marque/{marque}")
    public List<Vehicule> getVehiculesParMarque(@PathVariable("marque") String marque) {
        return vehiculeService.getVehiculesParMarque(marque);
    }

    @Operation(summary = "Rechercher des véhicules par catégorie", description = "Permet de filtrer la liste des véhicules selon leur catégorie (ex: SUV, Berline).")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping("/search-categorie/{categorie}")
    public List<Vehicule> getVehiculesParCategorie(@PathVariable("categorie") String categorie) {
        return vehiculeService.getVehiculesParCategorie(categorie);
    }

    @Operation(summary = "Rechercher des véhicules par statut", description = "Permet de filtrer la liste des véhicules selon leur statut (ex: DISPONIBLE).")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping("/search-statut/{statut}")
    public List<Vehicule> getVehiculesParStatut(@PathVariable("statut") String statut) {
        return vehiculeService.getVehiculesParStatut(statut);
    }

    @Operation(summary = "Rechercher des véhicules par marque partielle", description = "Permet de rechercher des véhicules dont la marque contient une chaîne de caractères.")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping("/search-marque-containing/{marque}")
    public List<Vehicule> getVehiculesParMarqueContenant(@PathVariable("marque") String marque) {
        return vehiculeService.getVehiculesParMarqueContenant(marque);
    }

    @Operation(summary = "Rechercher des véhicules par tarif supérieur", description = "Permet de filtrer les véhicules dont le tarif journalier est supérieur à une valeur donnée.")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping("/search-tarif-greater/{tarif}")
    public List<Vehicule> getVehiculesTarifSuperieur(@PathVariable("tarif") double tarif) {
        return vehiculeService.getVehiculesTarifSuperieur(tarif);
    }

    @Operation(summary = "Rechercher des véhicules par marque et statut", description = "Permet de filtrer les véhicules selon leur marque ET leur statut.")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping("/search-marque-statut")
    public List<Vehicule> getVehiculesParMarqueAndStatut(
            @RequestParam("marque") String marque,
            @RequestParam("statut") String statut) {
        return vehiculeService.getVehiculesParMarqueEtStatut(marque, statut);
    }

}