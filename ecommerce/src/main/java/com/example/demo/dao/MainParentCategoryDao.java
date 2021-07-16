package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MainParentCategory;
import com.example.demo.repository.MainParentCategoryRepository;

@Repository
public class MainParentCategoryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MainParentCategoryDao.class);
	
	@Autowired
	MainParentCategoryRepository mainParentCategoryRepository;
	
	public List<MainParentCategory> getMainParentCategories() throws Exception {
        logger.info("Entering Method getMainParentCategories ");
        List<MainParentCategory> mainParentCategoryList = new ArrayList<MainParentCategory> ();
        try {
        	mainParentCategoryList = mainParentCategoryRepository.findAll();
        } catch (Exception re) {
        	logger.error(" Error while executing the method getMainParentCategories " + re.getMessage() + re.getClass());
            throw re;
        } finally {
        	logger.info("Exiting the method getMainParentCategories");

        }
		return mainParentCategoryList;

	}
	
	
}