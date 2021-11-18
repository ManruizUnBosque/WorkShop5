package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Usuario;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements GeneralRepository<Usuario, String> {
    private final EntityManager manager;

    public UsuarioRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Usuario> findById(String id) {
        Usuario usuario = manager.find(Usuario.class, id);
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    public Optional<List<Usuario>> findByRole(String role) {
        List<Usuario> Usuario = manager.createNamedQuery("Usuario.findByRole", Usuario.class)
                .setParameter("role", role)
                .getResultList();
        return Usuario != null ? Optional.of(Usuario) : Optional.empty();
    }

    public List<Usuario> findAll() {
        return manager.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }

    @Override
    public Optional<Usuario> save(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    @Override
    public Optional<Usuario> update(Usuario usuario, String id) {

        return Optional.empty();
    }
}
