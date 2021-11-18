package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.Dueño;
import co.edu.unbosque.workshop5.jpa.repositories.GeneralRepository;
import co.edu.unbosque.workshop5.jpa.repositories.DueñoRepository;
import co.edu.unbosque.workshop5.resources.pojos.UsuarioPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class DueñoService {
    public Optional<UsuarioPOJO> createOwner(UsuarioPOJO ownerPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<Dueño, String> repository = new DueñoRepository(manager);
        Dueño dueño = new Dueño(
                ownerPOJO.getUsername(),
                ownerPOJO.getPassword(),
                ownerPOJO.getEmail(),
                ownerPOJO.getPersonId(),
                ownerPOJO.getName(),
                ownerPOJO.getAddress(),
                ownerPOJO.getNeighborhood()
        );

        Optional<Dueño> persistedOwner = repository.save(dueño);
        manager.close();

        return persistedOwner.map(value -> new UsuarioPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getPersonId(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }

    public Optional<UsuarioPOJO> updateOwner(UsuarioPOJO ownerPOJO, String id) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<Owner, String> repository = new OwnerRepository(manager);
        Owner owner = new Owner(
                ownerPOJO.getUsername(),
                ownerPOJO.getPassword(),
                ownerPOJO.getEmail(),
                ownerPOJO.getPersonId(),
                ownerPOJO.getName(),
                ownerPOJO.getAddress(),
                ownerPOJO.getNeighborhood()
        );

        Optional<Owner> persistedOwner = repository.update(owner, id);
        manager.close();

        return persistedOwner.map(value -> new UsuarioPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getPersonId(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }
}
