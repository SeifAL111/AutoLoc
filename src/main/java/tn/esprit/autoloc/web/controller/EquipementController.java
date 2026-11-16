package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/Equipement")
@RequiredArgsConstructor
@Tag(name = "Gestion des Équipements", description = "Endpoints pour la gestion des équipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @Operation(summary = "Récupérer tous les équipements", description = "Permet d'afficher la liste de tous les équipements enregistrés.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @Operation(summary = "Récupérer un équipement par ID", description = "Recherche et renvoie un équipement spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Équipement trouvé avec succès")
    @GetMapping("/retrieve-equipement/{id-equipement}")
    public Equipement retrieveEquipement(@PathVariable("id-equipement") Long idEquipement) {
        return equipementService.retrieveEquipement(idEquipement);
    }

    @Operation(summary = "Ajouter un équipement", description = "Enregistre un nouvel équipement dans le système.")
    @ApiResponse(responseCode = "200", description = "Équipement ajouté avec succès")
    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @Operation(summary = "Ajouter plusieurs équipements en lot", description = "Permet d'ajouter une liste d'équipements simultanément.")
    @ApiResponse(responseCode = "200", description = "Équipements ajoutés avec succès")
    @PostMapping("/add-equipements")
    public List<Equipement> addEquipements(@RequestBody List<Equipement> equipements) {
        return equipementService.addEquipements(equipements);
    }

    @Operation(summary = "Mettre à jour un équipement", description = "Modifie les informations d'un équipement existant.")
    @ApiResponse(responseCode = "200", description = "Équipement mis à jour avec succès")
    @PutMapping("/update-equipement")
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return equipementService.updateEquipement(equipement);
    }

    @Operation(summary = "Supprimer un équipement", description = "Supprime un équipement de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Équipement supprimé avec succès")
    @DeleteMapping("/remove-equipement/{id-equipement}")
    public void removeEquipement(@PathVariable("id-equipement") Long idEquipement) {
        equipementService.removeEquipement(idEquipement);
    }
}