package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.First;

import javax.persistence.EntityManager;
import java.util.Optional;

public class FirstRepository implements GeneralRepository<First, String> {
    private final EntityManager manager;

    public FirstRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<First> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<First> save(First official) {
        manager.getTransaction().begin();
        manager.persist(first);
        manager.getTransaction().commit();
        return official != null ? Optional.of(first) : Optional.empty();
    }


    @Override
    public Optional<First> update(First official, String id) {
        First updateFirst = manager.find(First.class, id);
        manager.getTransaction().begin();
        updateFirst.setEmail(first.getEmail());
        updateFirst.setName(first.getName());
        manager.merge(updatefirst);
        manager.getTransaction().commit();
        return Optional.of(updatefirst);
    }
}
