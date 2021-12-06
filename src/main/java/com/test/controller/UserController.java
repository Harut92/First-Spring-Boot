package com.test.controller;

import com.test.exceptions.BadRequestException;
import com.test.exceptions.NotFoundException;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

//    @RolesAllowed(value = "ROLE_ADMIN")
    @GetMapping("/{id}")
    User getById(@PathVariable int id) throws NotFoundException {
        return userService.getByID(id);

    }

    @GetMapping("/getByEmail")
    User getByEmail(@RequestParam("email") String email) throws NotFoundException {
        return userService.getByEmail(email);

    }

    @GetMapping("/login")
    User login(@RequestParam("email") String email, @RequestParam("password") String password) throws BadRequestException {
        return userService.login(email, password);

    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        userService.deleteById(id);
    }

//    @PostMapping("/saveUser")
//    void save(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
//        User user = new User(name, email, password);
//        userService.save(user);
//    }

    @PutMapping()
    void update(@RequestParam("id") int id, @RequestParam("name") String name) {
        userService.update(id, name);
    }

    @GetMapping("/verify")
    void verify(@RequestParam("email") String email){
        userService.verify(email);
    }

    @PostMapping("/register")
    public void register(@RequestBody() User user) throws NotFoundException {
        userService.register(user);
    }

    @GetMapping("/send")
    public void sendemail(@RequestParam("tomail") String tomail, @RequestParam("subject") String subject, @RequestParam("text") String text){
        userService.sendemail(tomail, subject, text);
    }

}
