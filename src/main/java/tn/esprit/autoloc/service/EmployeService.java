package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {

    private final EmployeRepository employeRepo;
    private final AgenceRepository agenceRepo; // Nécessaire pour récupérer l'agence lors de l'affectation

    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) employeRepo.findAll();
    }

    @Override
    public Employe addEmploye(Employe e) {
        return employeRepo.save(e);
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return employeRepo.save(e);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return employeRepo.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        return (List<Employe>) employeRepo.saveAll(employes);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = retrieveEmploye(idEmploye);
        if (employe != null) {
            employe.setAgence(null);
            return employeRepo.save(employe);
        }
        return null;
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = retrieveEmploye(idEmploye);
        Agence agence = agenceRepo.findById(idAgence).orElse(null);

        if (employe != null && agence != null) {
            employe.setAgence(agence);
            return employeRepo.save(employe);
        }
        return null;
    }
}