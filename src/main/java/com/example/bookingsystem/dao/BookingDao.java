package com.example.bookingsystem.dao;

import com.example.bookingsystem.model.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDao {

    @PersistenceContext(type =
            PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public BookingDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(Booking booking) {
        entityManager.persist(booking);
    }
}
