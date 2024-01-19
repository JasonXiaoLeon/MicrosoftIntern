package com.example.demo.week2.DAO;
import com.example.demo.week2.Press;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PressDAOImpl implements PressDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Press findById(int newsId) {
        return entityManager.find(Press.class, newsId);
    }

}
