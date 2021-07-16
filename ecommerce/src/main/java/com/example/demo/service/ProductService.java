package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductDao productDao;

	public List<Product> getProducts() throws Exception {
		logger.info("Entering Method getProducts");
		try {
			return productDao.getProducts();
		}catch(Exception e){
			logger.error("Error While executing the getProducts "+ e.getMessage());
			throw e;
		}finally {
			logger.info("Exiting the method getProducts");
		}
	}

}