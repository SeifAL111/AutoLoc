package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/Employe")
@RequiredArgsConstructor
@Tag(name = "Gestion des Employés", description = "Endpoints pour la gestion des employés")
public class EmployeController {

    private final IEmployeService employeService;

    @Operation(summary = "Récupérer tous les employés", description = "Permet d'afficher la liste de tous les employés enregistrés.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-employes")
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @Operation(summary = "Récupérer un employé par ID", description = "Recherche et renvoie un employé spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Employé trouvé avec succès")
    @GetMapping("/retrieve-employe/{id-employe}")
    public Employe retrieveEmploye(@PathVariable("id-employe") Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    @Operation(summary = "Ajouter un employé", description = "Enregistre un nouvel employé dans le système.")
    @ApiResponse(responseCode = "200", description = "Employé ajouté avec succès")
    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @Operation(summary = "Ajouter plusieurs employés en lot", description = "Permet d'ajouter une liste d'employés simultanément.")
    @ApiResponse(responseCode = "200", description = "Employés ajoutés avec succès")
    @PostMapping("/add-employes")
    public List<Employe> addEmployes(@RequestBody List<Employe> employes) {
        return employeService.addEmployes(employes);
    }

    @Operation(summary = "Mettre à jour un employé", description = "Modifie les informations d'un employé existant.")
    @ApiResponse(responseCode = "200", description = "Employé mis à jour avec succès")
    @PutMapping("/update-employe")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }

    @Operation(summary = "Supprimer un employé", description = "Supprime un employé de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Employé supprimé avec succès")
    @DeleteMapping("/remove-employe/{id-employe}")
    public void removeEmploye(@PathVariable("id-employe") Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }



    @Operation(summary = "Désaffecter un employé", description = "Retire l'employé de son agence actuelle (met l'agence à null).")
    @ApiResponse(responseCode = "200", description = "Employé désaffecté avec succès")
    @PutMapping("/desaffecter-employe/{id-employe}")
    public Employe desaffecterEmploye(@PathVariable("id-employe") Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @Operation(summary = "Affecter un employé à une agence", description = "Mute ou affecte un employé vers une agence spécifique.")
    @ApiResponse(responseCode = "200", description = "Employé affecté avec succès")
    @PutMapping("/affecter-employe/{id-employe}/{id-agence}")
    public Employe affecterEmploye(
            @PathVariable("id-employe") Long idEmploye,
            @PathVariable("id-agence") Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}