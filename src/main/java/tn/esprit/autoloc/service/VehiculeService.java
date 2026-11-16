package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeService implements IVehiculeService {

    private final VehiculeRepository vehiculeRepo;
    private final AgenceRepository agenceRepo;         // Nécessaire pour rattacher le véhicule à l'agence
    private final EquipementRepository equipementRepo; // Nécessaire pour gérer les équipements (siège bébé, etc.)



    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) vehiculeRepo.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepo.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return (List<Vehicule>) vehiculeRepo.saveAll(vehicules);
    }

    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        Agence agence = agenceRepo.findById(idAgence).orElse(null);

        if (vehicule != null && agence != null) {
            vehicule.setAgence(agence);
            return vehiculeRepo.save(vehicule);
        }
        return null;
    }

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        Equipement equipement = equipementRepo.findById(idEquipement).orElse(null);

        if (vehicule != null && equipement != null) {
            if (!vehicule.getEquipements().contains(equipement)) {
                vehicule.getEquipements().add(equipement);
            }
            return vehiculeRepo.save(vehicule);
        }
        return null;
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        Equipement equipement = equipementRepo.findById(idEquipement).orElse(null);

        if (vehicule != null && equipement != null) {
            vehicule.getEquipements().remove(equipement);
            return vehiculeRepo.save(vehicule);
        }
        return null;
    }

    @Override
    public List<Vehicule> getVehiculesParMarque(String marque) {
        // On utilise l'objet injecté "vehiculeRepo" (et non "vehiculeRepository")
        return vehiculeRepo.findByMarque(marque);
    }

    @Override
    public List<Vehicule> getVehiculesParCategorie(String categorie) {
        return vehiculeRepo.findByCategorie(categorie);
    }

    @Override
    public List<Vehicule> getVehiculesParStatut(String statut) {
        return vehiculeRepo.findByStatut(statut);
    }

    @Override
    public List<Vehicule> getVehiculesParMarqueContenant(String marque) {
        return vehiculeRepo.findByMarqueContainingIgnoreCase(marque);
    }

    @Override
    public List<Vehicule> getVehiculesTarifSuperieur(double tarif) {
        return vehiculeRepo.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> getVehiculesParMarqueEtStatut(String marque, String statut) {
        return vehiculeRepo.findByMarqueAndStatut(marque, statut);
    }
}