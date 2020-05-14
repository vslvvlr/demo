package com.example.demo.repos;

import com.example.demo.domain.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void updateAmount (User user) {
        Session session = this.getSession();
        int oldAmount = user.getAmount();
        oldAmount++;
        user.setAmount(oldAmount);
        session.save(user);
        session.close();
    }



}
