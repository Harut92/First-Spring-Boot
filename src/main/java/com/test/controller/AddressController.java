//package com.test.controller;
//
//import com.test.exceptions.NotFoundException;
//import com.test.model.Address;
//import com.test.model.User;
//import com.test.service.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RequestMapping("/address")
//@RestController
//public class AddressController {
//    @Autowired
//    private AddressService addressService;
//
//    @GetMapping("/{id}")
//    Address getById(@PathVariable int id) throws NotFoundException {
//        return addressService.getByID(id);
//    }
//
//    @PostMapping("/{id}")
//    void delete(@PathVariable int id) {
//        addressService.deleteById(id);
//    }
//
//    @PutMapping("/update")
//    void update(@RequestParam("id") int id, @RequestParam("street") String street) {
//        addressService.update(id, street);
//    }
//
//    @PostMapping
//    public void create(@RequestBody() Address address) {
//        addressService.save(address);
//    }
//}
