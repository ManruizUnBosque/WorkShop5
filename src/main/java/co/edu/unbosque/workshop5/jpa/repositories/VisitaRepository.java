package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Visita;

import javax.persistence.EntityManager;
import java.util.Optional;

public class VisitaRepository implements GeneralRepository<Visita, Integer> {
    private final EntityManager manager;

    public VisitaRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Visita> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Visita> save(Visita visita) {
        manager.getTransaction().begin();
        manager.merge(visita);
        manager.getTransaction().commit();
        return visita != null ? Optional.of(visita) : Optional.empty();
    }

    @Override
    public Optional<Visita> update(Visita visita, Integer id) {
        return Optional.empty();
    }
}
