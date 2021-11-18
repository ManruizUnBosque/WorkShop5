package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Veterinario;

import javax.persistence.EntityManager;
import java.util.Optional;

public class VeterinarioRepository implements GeneralRepository<Veterinario, String> {
    private final EntityManager manager;

    public VeterinarioRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Veterinario> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Veterinario> save(Veterinario veterinario) {
        manager.getTransaction().begin();
        manager.persist(veterinario);
        manager.getTransaction().commit();
        return veterinario != null ? Optional.of(veterinario) : Optional.empty();
    }

    @Override
    public Optional<Veterinario> update(Veterinario veterinario, String id) {
        Veterinario updateVeterinario = manager.find(Veterinario.class, id);
        manager.getTransaction().begin();
        updateVeterinario.setEmail(veterinario.getEmail());
        updateVeterinario.setName(veterinario.getName());
        updateVeterinario.setAddress(veterinario.getAddress());
        updateVeterinario.setNeighborhood(veterinario.getNeighborhood());
        manager.merge(updateVeterinario);
        manager.getTransaction().commit();
        return Optional.of(updateVeterinario);
    }
}
