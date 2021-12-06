package com.test.service;

import com.test.exceptions.BadRequestException;
import com.test.exceptions.NotFoundException;
import com.test.model.Phone;
import com.test.model.Status;
import com.test.model.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private MailSender mailSender;

    public void save(User user) {
//        phoneService.save(user.getPhone());
        userRepository.save(user);

    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByID(int id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();

        }
        throw new NotFoundException();
    }

    public User getByEmail(String mail) throws NotFoundException {
        if (userRepository.getByEmail(mail) != null) {
            return userRepository.getByEmail(mail);
        }
        throw new NotFoundException();
    }

    @Override
    public void update(int id, String name) {
        User user = new User();
        try {
            user = getByID(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        user.setName(name);
    }




    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String email, String password) throws BadRequestException {
        if (userRepository.login(email, password).getStatus() == Status.VERIFIED) {
            return userRepository.login(email, password);
        }
        throw new BadRequestException();
    }

    @Transactional
    @Override
    public void register(User user) throws NotFoundException {
        user.setStatus(Status.UNVERIFIED);

        Phone phone = user.getPhone();
        phoneService.save(phone);

        if (phone == null) {
            throw new NotFoundException();
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        sendemail(user.getEmail(), "welcome", "please confirm http://localhost:8080/user/verify?email=" + user.getEmail());

    }

    @Override
    public void verify(String email) {
        User user = new User();
        try {
            user = getByEmail(email);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        user.setStatus(Status.VERIFIED);
        userRepository.save(user);

    }

    @Override
    public void sendemail(String tomail, String subject, String text) {
        mailSender.sendSimpleMessage(tomail, subject, text);
    }


}

