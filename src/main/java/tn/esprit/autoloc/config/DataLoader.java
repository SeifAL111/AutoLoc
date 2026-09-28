package tn.esprit.autoloc.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository vehiculeRepository) {
        return args -> {
            if (vehiculeRepository.count() == 0) {
                Vehicule v1 = Vehicule.builder()
                        .immatriculation("220-TN-1234")
                        .marque("Peugeot")
                        .modele("208")
                        .tarifJournalier(120.00)
                        .statut(StatutVehicule.DISPONIBLE)
                        .categorie(CategorieVehicule.CITADINE)
                        .build();

                Vehicule v2 = Vehicule.builder()
                        .immatriculation("230-TN-5678")
                        .marque("Volkswagen")
                        .modele("Golf 8")
                        .tarifJournalier(180.00)
                        .statut(StatutVehicule.DISPONIBLE)
                        .categorie(CategorieVehicule.BERLINE)
                        .build();

                vehiculeRepository.save(v1);
                vehiculeRepository.save(v2);

                System.out.println("✅ 2 véhicules de démonstration ont été insérés avec succès !");
            }
        };
    }
}