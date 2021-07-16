package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ParentCategory;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Integer>{

    @Query(value = "select pc.parent_cat_id,pc.parent_cat_name,pc.main_parent_cat_id from parent_category pc where pc.main_parent_cat_id = :main_parent_cat_id ", nativeQuery = true)
	List<ParentCategory> findAllById(@Param("main_parent_cat_id") Integer mainParentCatId);
	


}