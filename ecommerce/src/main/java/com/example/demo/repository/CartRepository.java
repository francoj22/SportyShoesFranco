package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	  @Query(value = "select count(c.user_id) from cart c where c.user_id = :user_id " , nativeQuery = true)
	  Integer  cartCountById(@Param("user_id") int userId);

	  @Query(value = "select c.cart_id,c.user_id,product_id,qty from cart c where c.user_id = :user_id " , nativeQuery = true)
	  List findAllById(@Param("user_id") Integer userId);


}