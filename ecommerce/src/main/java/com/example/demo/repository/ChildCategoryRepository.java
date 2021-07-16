package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ChildCategory;
import com.example.demo.entity.ParentCategory;

@Repository
public interface ChildCategoryRepository extends JpaRepository<ChildCategory, Integer>{

    @Query(value = "select cc.child_cat_id,pc.child_cat_name,pc.parent_cat_id from child_category cc where cc.parent_cat_id = :parent_cat_id ", nativeQuery = true)
	List<ChildCategory> findAllById(@Param("parent_cat_id") Integer parentCatId);
	


}