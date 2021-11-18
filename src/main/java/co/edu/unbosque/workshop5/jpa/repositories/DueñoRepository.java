package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Dueño;

import javax.persistence.EntityManager;
import java.util.Optional;

public class DueñoRepository implements GeneralRepository<Dueño, String> {
    private final EntityManager manager;

    public DueñoRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Dueño> findById(String id) {
        Dueño dueño = manager.find(Dueño.class, id);
        return dueño != null ? Optional.of(dueño) : Optional.empty();
    }

    @Override
    public Optional<Dueño> save(Dueño dueño) {
        manager.getTransaction().begin();
        manager.persist(dueño);
        manager.getTransaction().commit();
        return dueño != null ? Optional.of(dueño) : Optional.empty();
    }

    @Override
    public Optional<Dueño> update(Dueño dueño, String id) {
        Dueño updateDueño = manager.find(Dueño.class, id);
        manager.getTransaction().begin();
        updateDueño.setEmail(dueño.getEmail());
        updateDueño.setName(dueño.getName());
        updateDueño.setAddress(dueño.getAddress());
        updateDueño.setNeighborhood(dueño.getNeighborhood());
        manager.merge(updateDueño);
        manager.getTransaction().commit();
        return Optional.of(updateDueño);
    }
}
