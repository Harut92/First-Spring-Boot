package com.test.service;


import com.test.exceptions.BadRequestException;
import com.test.exceptions.NotFoundException;
import com.test.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void save(User user);

    void deleteById(int id);

    User getByID(int id) throws NotFoundException;

    void update(int id, String name);

    User getByEmail(String mail) throws NotFoundException;

    void delete(int id);

    User login(String email, String password) throws BadRequestException;

    void register(User user) throws NotFoundException;

    void verify(String email);

    void sendemail(String tomail, String subject, String text);
}
