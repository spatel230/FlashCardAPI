package com.example.demo.dao;

import com.example.demo.entity.FlashCard;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FlashCardIMPL implements FlashCardDAO{
    private final EntityManager entityManager;

    public FlashCardIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<FlashCard> findAllFlashCards() {
        Session cSession=entityManager.unwrap(Session.class);
        Query<FlashCard> myQuery=cSession.createQuery("from FlashCard");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public FlashCard findById(int ID) {
        Session cSession=entityManager.unwrap(Session.class);
        return cSession.get(FlashCard.class, ID);
    }

    @Override
    @Transactional
    public void save(FlashCard newFlashCard) {
        Session cSession=entityManager.unwrap(Session.class);
        cSession.saveOrUpdate(newFlashCard);

    }

    @Override
    @Transactional
    public void deleteFlashCardById(int ID) {
        Session cSession=entityManager.unwrap(Session.class);
        FlashCard deleteFlashCard=cSession.get(FlashCard.class, ID);
        cSession.delete(deleteFlashCard);
    }
}
