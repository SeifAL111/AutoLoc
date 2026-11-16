package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/Maintenance")
@RequiredArgsConstructor
@Tag(name = "Gestion des Maintenances", description = "Endpoints pour la gestion des maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Récupérer toutes les maintenances", description = "Permet d'afficher la liste de toutes les maintenances enregistrées.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @Operation(summary = "Récupérer une maintenance par ID", description = "Recherche et renvoie une maintenance spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Maintenance trouvée avec succès")
    @GetMapping("/retrieve-maintenance/{id-maintenance}")
    public Maintenance retrieveMaintenance(@PathVariable("id-maintenance") Long idMaintenance) {
        return maintenanceService.retrieveMaintenance(idMaintenance);
    }

    @Operation(summary = "Ajouter une maintenance", description = "Enregistre une nouvelle maintenance dans le système.")
    @ApiResponse(responseCode = "200", description = "Maintenance ajoutée avec succès")
    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @Operation(summary = "Ajouter plusieurs maintenances en lot", description = "Permet d'ajouter une liste de maintenances simultanément.")
    @ApiResponse(responseCode = "200", description = "Maintenances ajoutées avec succès")
    @PostMapping("/add-maintenances")
    public List<Maintenance> addMaintenances(@RequestBody List<Maintenance> maintenances) {
        return maintenanceService.addMaintenances(maintenances);
    }

    @Operation(summary = "Mettre à jour une maintenance", description = "Modifie les informations d'une maintenance existante.")
    @ApiResponse(responseCode = "200", description = "Maintenance mise à jour avec succès")
    @PutMapping("/update-maintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(maintenance);
    }

    @Operation(summary = "Supprimer une maintenance", description = "Supprime une maintenance de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Maintenance supprimée avec succès")
    @DeleteMapping("/remove-maintenance/{id-maintenance}")
    public void removeMaintenance(@PathVariable("id-maintenance") Long idMaintenance) {
        maintenanceService.removeMaintenance(idMaintenance);
    }
}