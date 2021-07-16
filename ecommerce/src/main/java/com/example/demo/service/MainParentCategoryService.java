package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.MainParentCategoryDao;
import com.example.demo.entity.Category;
import com.example.demo.entity.MainParentCategory;

@Service
public class MainParentCategoryService {

	private static final Logger logger = LoggerFactory.getLogger(MainParentCategoryService.class);

	@Autowired
	MainParentCategoryDao mainParentCategoryDao;

	public List<MainParentCategory> getMainParentCategories() throws Exception {
		logger.info("Entering Method getMainParentCategories");
		try {
			return mainParentCategoryDao.getMainParentCategories();
		}catch(Exception e){
			logger.error("Error While executing the getMainParentCategories "+ e.getMessage());
			throw e;
		}finally {
			logger.info("Exiting the method getMainParentCategories");
		}
	}

}