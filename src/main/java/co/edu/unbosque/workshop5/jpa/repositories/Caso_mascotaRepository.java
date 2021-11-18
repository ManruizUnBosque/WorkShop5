package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Caso_mascota;

import javax.persistence.EntityManager;
import java.util.Optional;

public class Caso_mascotaRepository implements GeneralRepository<Caso_mascota, Integer> {
    private final EntityManager manager;

    public Caso_mascotaRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Caso_mascota> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Caso_mascota> save(Caso_mascota Caso_mascota) {
        manager.getTransaction().begin();
        manager.merge(Caso_mascota);
        manager.getTransaction().commit();
        return Caso_mascota != null ? Optional.of(Caso_mascota) : Optional.empty();
    }

    @Override
    public Optional<Caso_mascota> update(Caso_mascota Caso_mascota, Integer id) {
        return Optional.empty();
    }
}
