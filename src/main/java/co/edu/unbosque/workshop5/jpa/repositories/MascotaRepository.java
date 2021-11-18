package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Mascota;

import javax.persistence.EntityManager;
import java.util.Optional;

public class MascotaRepository implements GeneralRepository<Mascota, Integer> {
    private final EntityManager manager;

    public MascotaRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Mascota> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Mascota> save(Mascota mascota) {
        manager.getTransaction().begin();
        manager.persist(mascota);
        manager.getTransaction().commit();
        return mascota != null ? Optional.of(mascota) : Optional.empty();
    }

    @Override
    public Optional<Mascota> update(Mascota mascota, Integer id) {
        Mascota updateMascota = manager.find(Mascota.class, id);
        manager.getTransaction().begin();
        updateMascota.setPetId(mascota.getPetId());
        updateMascota.setMicrochip(mascota.getMicrochip());
        updateMascota.setName(mascota.getName());
        updateMascota.setSpecies(mascota.getSpecies());
        updateMascota.setRace(mascota.getRace());
        updateMascota.setSize(mascota.getSize());
        updateMascota.setSex(mascota.getSex());
        updateMascota.setPicture(mascota.getPicture());
        updateMascota.setOwner(mascota.getDueño());
        manager.merge(updateMascota);
        manager.getTransaction().commit();
        return Optional.of(updateMascota);
    }


}
