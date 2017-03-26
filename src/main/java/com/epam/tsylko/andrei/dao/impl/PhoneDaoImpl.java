package com.epam.tsylko.andrei.dao.impl;


import com.epam.tsylko.andrei.dao.PhoneDao;
import com.epam.tsylko.andrei.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PhoneDaoImpl implements PhoneDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPhone(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(phone);
        session.flush();
    }

    @Override
    public void updatePhone(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(phone);
        session.flush();
    }

    @Override
    public void deletePhone(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(phone);
        session.flush();
    }

    @Override
    public Phone getPhoneById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Phone phone = (Phone) session.get(Phone.class, id);
        session.flush();
        return phone;
    }
}
