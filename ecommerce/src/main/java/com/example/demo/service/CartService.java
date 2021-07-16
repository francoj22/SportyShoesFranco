package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartDao;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProducts;

@Service
public class CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    CartDao cartDao;

    public void addToCart(Cart cart) throws Exception {
        logger.info("Entering Method addToCart");
        try {
            cartDao.addToCart(cart);
        } catch (Exception e) {
            logger.error("Error While executing the addToCart " + e.getMessage());
            throw e;
        } finally {
            logger.info("Exiting the method addToCart");
        }

    }

    public Integer cartCount(int userId) {
        logger.info("Entering Method cartCount");
        try {
            return cartDao.cartCount(userId);
        } catch (Exception e) {
            logger.error("Error While executing the cartCount " + e.getMessage());
            throw e;
        } finally {
            logger.info("Exiting the method cartCount");
        }

    }

	public List<CartProducts> cartDetails(int userId) {
        logger.info("Entering Method cartDetails");
        try {
            return cartDao.cartDetails(userId);
        } catch (Exception e) {
            logger.error("Error While executing the cartDetails " + e.getMessage());
            throw e;
        } finally {
            logger.info("Exiting the method cartDetails");
        }
	}

	public void deleteCart(int cartId) {
        logger.info("Entering Method deleteCart");
        try {
             cartDao.deleteCart(cartId);
        } catch (Exception e) {
            logger.error("Error While executing the deleteCart " + e.getMessage());
            throw e;
        } finally {
            logger.info("Exiting the method deleteCart");
        }
	}

	public void updateCart(int cartId, int qty) {
        logger.info("Entering Method updateCart");
        try {
             cartDao.updateCart(cartId,qty);
        } catch (Exception e) {
            logger.error("Error While executing the updateCart " + e.getMessage());
            throw e;
        } finally {
            logger.info("Exiting the method updateCart");
        }
		
	}
}