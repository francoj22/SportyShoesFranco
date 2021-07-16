package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Repository
public class ProductDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts() throws Exception {
        logger.info("Entering Method getProducts ");
        List<Product> productList = new ArrayList<Product> ();
        try {
        	productList = productRepository.findAll();
        	
        } catch (Exception re) {
        	logger.error(" Error while executing the method getProducts " + re.getMessage() + re.getClass());
            throw re;
        } finally {
        	logger.info("Exiting the method getProducts");

        }
		return productList;

	}
	
	
}