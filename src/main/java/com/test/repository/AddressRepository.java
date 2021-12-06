//package com.test.repository;
//
//import com.test.model.Address;
//import com.test.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface AddressRepository extends JpaRepository<Address,Integer> {
//    @Query(value = "Select u from Address u where u.id = :id")
//    Address getById(int id);
//}
