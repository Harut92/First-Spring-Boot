package com.test.repository;

import com.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "Select u from User u where u.email = :email")
    User getByEmail(String email);
    List<User>getAllByName(String name);

    @Query(value = "Select u from User u where u.email = :email and u.password=:password")
    User login(String email, String password);

    @Query(value = "Select u from User u where u.email = :email")
    void verify(String email);
}
