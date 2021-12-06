package com.test.repository;



import com.test.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhoneRepository extends JpaRepository<Phone,Integer> {
    @Query(value = "Select p from Phone p where p.id = :id")
    Phone getById(int id);
}
