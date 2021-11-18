package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.First;
import co.edu.unbosque.workshop5.jpa.repositories.GeneralRepository;
import co.edu.unbosque.workshop5.jpa.repositories.FirstRepository;
import co.edu.unbosque.workshop5.resources.pojos.UsuarioPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class FirstService {
    public Optional<UsuarioPOJO> createOfficial(UsuarioPOJO officialPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<First, String> repository = new FirstRepository(manager);
        First official = new First(
                officialPOJO.getUsername(),
                officialPOJO.getPassword(),
                officialPOJO.getEmail(),
                officialPOJO.getName()
        );

        Optional<First> persistedOfficial = repository.save(official);
        manager.close();

        return persistedOfficial.map(value -> new UsuarioPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName()
        ));
    }

    public Optional<UsuarioPOJO> updatefirst(UsuarioPOJO officialPOJO, String id) {
        EntityManager manager = Persistence.createEntityManagerFactory("workshop5").createEntityManager();
        GeneralRepository<First, String> repository = new FirstRepository(manager);
        First official = new First(
                officialPOJO.getUsername(),
                officialPOJO.getPassword(),
                officialPOJO.getEmail(),
                officialPOJO.getName()
        );

        Optional<First> persistedOfficial = repository.update(official, id);
        manager.close();

        return persistedOfficial.map(value -> new UsuarioPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName()
        ));
    }
}
