//package com.test.service;
//
//import com.test.exceptions.NotFoundException;
//import com.test.model.Address;
//import com.test.model.User;
//import com.test.repository.AddressRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AddressServiceImpl implements AddressService {
//    @Autowired
//    private AddressRepository addressRepository;
//
//
//    @Override
//    public void save(Address address) {
//        addressRepository.save(address);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        addressRepository.deleteById(id);
//    }
//
//    @Override
//    public Address getByID(int id) throws NotFoundException {
//        Optional<Address> optionalAddress = addressRepository.findById(id);
//        if (optionalAddress.isPresent()) {
//            return optionalAddress.get();
//        }
//        throw new NotFoundException();
//    }
//
//    @Override
//    public void update(int id, String street) {
//        Address address = new Address();
//        try {
//            address = getByID(id);
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }
//        address.setStreet(street);
//    }
//
//    @Override
//    public void delete(int id) {
//        addressRepository.deleteById(id);
//    }
//}
