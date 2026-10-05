package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
public class EquipementService implements IEquipementService {

    EquipementRepository equipementRepo;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return (List<Equipement>) equipementRepo.findAll();
    }

    @Override
    public Equipement addEquipement(Equipement eq) {
        return equipementRepo.save(eq);
    }

    @Override
    public Equipement updateEquipement(Equipement eq) {
        return equipementRepo.save(eq);
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return equipementRepo.findById(idEquipement).orElse(null);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        equipementRepo.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> equipements) {
        return (List<Equipement>) equipementRepo.saveAll(equipements);
    }
}