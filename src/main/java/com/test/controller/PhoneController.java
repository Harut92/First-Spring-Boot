package com.test.controller;


import com.test.exceptions.NotFoundException;

import com.test.model.Phone;
import com.test.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/phone")
@RestController
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/{id}")
    Phone getById(@PathVariable int id) throws NotFoundException {
        return phoneService.getByID(id);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        phoneService.deleteById(id);
    }

    @PutMapping("/update")
    void update(@RequestParam("id") int id, @RequestParam("model") String model) {
        phoneService.update(id, model);
    }


    @PostMapping
    public void create(@RequestBody() Phone phone) {
        phoneService.save(phone);
    }
}
