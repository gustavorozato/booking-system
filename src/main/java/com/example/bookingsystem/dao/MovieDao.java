package com.example.bookingsystem.dao;

import com.example.bookingsystem.model.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MovieDao {

    @PersistenceContext(type =
            PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public MovieDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Movie> find(String id) {
        return Optional.ofNullable(entityManager.find(Movie.class, id));
    }

    public Optional<Movie> findByName(String movieName) {
        Query query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.name = :name");
        query.setParameter("name", movieName);
        return Optional.ofNullable((Movie) query.getSingleResult());
    }

    @Transactional
    public void add(Movie movie) {
        entityManager.persist(movie);
    }

    public void update(Movie movie) {
        entityManager.merge(movie);
    }
}
