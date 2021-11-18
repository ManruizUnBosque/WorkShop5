package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.Visit;
import co.edu.unbosque.workshop5.jpa.repositories.GeneralRepository;
import co.edu.unbosque.workshop5.jpa.repositories.VisitaRepository;
import co.edu.unbosque.workshop5.resources.pojos.VisitPOJO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

public class VisitService {
    public Optional<VisitPOJO> createVisit(VisitPOJO visitPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<Visit, Integer> repository = new VisitaRepository(manager);
        Visit visit = new Visit(
                visitPOJO.getVisitId(),
                visitPOJO.getType(),
                visitPOJO.getDescription()
        );

        Optional<Visit> persistedVisit = repository.save(visit);
        manager.close();

        return persistedVisit.map(value -> new VisitPOJO(
                value.getVisitId(),
                value.getType(),
                value.getDescription()
        ));
    }
}
