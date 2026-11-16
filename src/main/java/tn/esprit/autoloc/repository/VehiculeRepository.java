package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorie(String categorie);
    List<Vehicule> findByStatut(String statut);
    List<Vehicule> findByMarqueContainingIgnoreCase(String marque);
    List<Vehicule> findByTarifJournalierGreaterThan(double tarif);
    List<Vehicule> findByMarqueAndStatut(String marque, String statut);
}