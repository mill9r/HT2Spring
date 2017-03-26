package com.epam.tsylko.andrei.dao;


import com.epam.tsylko.andrei.model.Phone;

public interface PhoneDao {
    void addPhone(Phone phone);
    void updatePhone(Phone phone);
    void deletePhone(Phone phone);
    Phone getPhoneById(int id);
}
