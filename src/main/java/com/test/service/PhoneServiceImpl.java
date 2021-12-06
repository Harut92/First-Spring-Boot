package com.test.service;

import com.test.exceptions.NotFoundException;

import com.test.model.Phone;

import com.test.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;


    @Transactional()
    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void deleteById(int id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public Phone getByID(int id) throws NotFoundException {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            return optionalPhone.get();
        }
        throw new NotFoundException();
    }

    @Override
    public void update(int id, String model) {
        Phone phone = new Phone();
        try {
            phone = getByID(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        phone.setModel(model);
    }

    @Override
    public void delete(int id) {
        phoneRepository.deleteById(id);
    }
}
