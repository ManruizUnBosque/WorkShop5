package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.PetCase;
import co.edu.unbosque.workshop5.jpa.repositories.GeneralRepository;
import co.edu.unbosque.workshop5.jpa.repositories.Caso_mascotaRepository;
import co.edu.unbosque.workshop5.resources.pojos.PetCasePOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class PetCaseService {
    public Optional<PetCasePOJO> createPetCase(PetCasePOJO petCasePOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<PetCase, Integer> repository = new Caso_mascotaRepository(manager);
        PetCase petCase = new PetCase(
                petCasePOJO.getCaseId(),
                petCasePOJO.getType(),
                petCasePOJO.getDescription()
        );
        Optional<PetCase> persistedPetCase = repository.save(petCase);
        manager.close();
        return persistedPetCase.map(value -> new PetCasePOJO(
                value.getCaseId(),
                value.getType(),
                value.getDescription()
        ));
    }
}
