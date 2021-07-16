package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.MainParentCategory;

@Repository
public interface MainParentCategoryRepository extends JpaRepository<MainParentCategory, Integer>{
	


}