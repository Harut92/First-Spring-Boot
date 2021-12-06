package com.test.service;

import com.test.exceptions.NotFoundException;

import com.test.model.Phone;

public interface PhoneService {
    void save(Phone phone);

    void deleteById(int id);

    Phone getByID(int id) throws NotFoundException;

    void update(int id, String model);

    void delete(int id);
}
