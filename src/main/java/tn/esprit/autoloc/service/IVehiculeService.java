package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);

    Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    List<Vehicule> getVehiculesParMarque(String marque);
    List<Vehicule> getVehiculesParCategorie(String categorie);
    List<Vehicule> getVehiculesParStatut(String statut);
    List<Vehicule> getVehiculesParMarqueContenant(String marque);
    List<Vehicule> getVehiculesTarifSuperieur(double tarif);
    List<Vehicule> getVehiculesParMarqueEtStatut(String marque, String statut);

}