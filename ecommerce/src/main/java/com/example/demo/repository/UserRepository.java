package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
    @Query(value = "select u.usersId,u.firstName,u.lastName,u.phone,u.email,u.gender,u.password from users u where u.email = :email and u.password = :password" , nativeQuery = true)
    List<User> findALL(@Param("email") String email, @Param("password") String password);
    
    @Modifying
    @Transactional 
    @Query(value = "update users u set u.password = :password where u.email = :email" , nativeQuery = true)
    void updatePassword(@Param("email") String email, @Param("password") String password);


}