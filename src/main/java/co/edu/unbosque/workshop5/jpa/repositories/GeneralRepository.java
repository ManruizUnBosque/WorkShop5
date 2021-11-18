package co.edu.unbosque.workshop5.jpa.repositories;

import java.util.Optional;

public interface GeneralRepository<T, K> {
    Optional<T> findById(K id);
    Optional<T> save(T t);
    Optional<T> update(T t, K id);
}
