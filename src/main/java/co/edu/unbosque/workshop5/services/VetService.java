package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.Vet;
import co.edu.unbosque.workshop5.jpa.repositories.GeneralRepository;
import co.edu.unbosque.workshop5.jpa.repositories.VeterinarioRepository;
import co.edu.unbosque.workshop5.resources.pojos.UsuarioPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class VetService {
    public Optional<UsuarioPOJO> createVet(UsuarioPOJO vetPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<Vet, String> repository = new VeterinarioRepository(manager);
        Vet vet = new Vet(
                vetPOJO.getUsername(),
                vetPOJO.getPassword(),
                vetPOJO.getEmail(),
                vetPOJO.getName(),
                vetPOJO.getAddress(),
                vetPOJO.getNeighborhood()
        );
        Optional<Vet> persistedVet = repository.save(vet);
        manager.close();
        return persistedVet.map(value -> new UsuarioPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }

    public Optional<UsuarioPOJO> updateVet(UsuarioPOJO vetPOJO, String id) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<Vet, String> repository = new VeterinarioRepository(manager);
        Vet vet = new Vet(
                vetPOJO.getUsername(),
                vetPOJO.getPassword(),
                vetPOJO.getEmail(),
                vetPOJO.getName(),
                vetPOJO.getAddress(),
                vetPOJO.getNeighborhood()
        );
        Optional<Vet> persistedVet = repository.update(vet, id);
        manager.close();
        return persistedVet.map(value -> new UsuarioPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }
}
