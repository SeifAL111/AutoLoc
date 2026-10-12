package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/Client")
@RequiredArgsConstructor
@Tag(name = "Gestion des Clients", description = "Endpoints pour la gestion des clients")
public class ClientController {

    private final IClientService clientService;

    @Operation(summary = "Ajouter un client", description = "Enregistre un nouveau client dans le système.")
    @ApiResponse(responseCode = "200", description = "Client ajouté avec succès")
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client c) {
        return clientService.addClient(c);
    }

    @Operation(summary = "Récupérer tous les clients", description = "Permet d'afficher la liste de tous les clients enregistrés.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Récupérer un client par ID", description = "Recherche et renvoie un client spécifique grâce à son identifiant.")
    @ApiResponse(responseCode = "200", description = "Client trouvé avec succès")
    @GetMapping("/retrieve-client/{id-client}")
    public Client retrieveClient(@PathVariable("id-client") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @Operation(summary = "Mettre à jour un client", description = "Modifie les informations d'un client existant.")
    @ApiResponse(responseCode = "200", description = "Client mis à jour avec succès")
    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        return clientService.updateClient(c);
    }

    @Operation(summary = "Ajouter plusieurs clients en lot", description = "Permet d'ajouter une liste de clients simultanément.")
    @ApiResponse(responseCode = "200", description = "Clients ajoutés avec succès")
    @PostMapping("/add-clients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }

    @Operation(summary = "Supprimer un client", description = "Supprime un client de la base de données via son identifiant.")
    @ApiResponse(responseCode = "200", description = "Client supprimé avec succès")
    @DeleteMapping("/remove-client/{id-client}")
    public void removeClient(@PathVariable("id-client") Long idClient) {
        clientService.removeClient(idClient);
    }
}