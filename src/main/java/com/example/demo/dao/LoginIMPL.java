package com.example.demo.dao;

import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LoginIMPL implements LoginDAO{
    private final EntityManager entityManager;

    public LoginIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> findAllUser() {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> myQuery=cSession.createQuery("from User");
        return myQuery.getResultList();
    }

    @Override
    public User ifCredentialsMatch(User check) {
        Session cSession=entityManager.unwrap(Session.class);
        String sql="from User c where (c.Username=\'"+check.getUsername()+"\'AND c.Password=\'"+check.getPassword()+"\')";
        Query<User> myQuery=cSession.createQuery(sql);
        try {
            return myQuery.getSingleResult();
        }catch (Exception e){
            return new User();
        }
    }

    @Override
    public User ifUsernameIsTaken(String name) {
        Session cSession=entityManager.unwrap(Session.class);
        String sql="from User c where c.Username=\'"+name+"\'";
        Query<User> myQuery=cSession.createQuery(sql);
        try {
            return myQuery.getSingleResult();
        }catch (Exception e){
            return new User();
        }
    }

    @Override
    public User findById(int ID) {
        Session cSession=entityManager.unwrap(Session.class);
        return cSession.get(User.class, ID);
    }

    @Override
    public void save(User newUser) {
        Session cSession=entityManager.unwrap(Session.class);
        cSession.saveOrUpdate(newUser);
    }

    @Override
    public void deleteUserById(int ID) {
        Session cSession=entityManager.unwrap(Session.class);
        User deleteUser=cSession.get(User.class, ID);
        cSession.delete(deleteUser);
    }
}
