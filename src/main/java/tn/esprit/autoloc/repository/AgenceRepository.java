package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domain.Agence;
import java.util.List;

public interface AgenceRepository extends CrudRepository<Agence, Long> {
    List<Agence> findByVille(String ville);
}