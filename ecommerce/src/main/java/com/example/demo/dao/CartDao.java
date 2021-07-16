package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProducts;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;

@Repository
@SuppressWarnings({
    "unchecked",
    "deprecation",
    "rawtypes"
})
public class CartDao {

    private static final Logger logger = LoggerFactory.getLogger(CartDao.class);

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    public void addToCart(Cart cart) throws Exception {
        logger.info("Entering Method addToCart  ");
        try {
            if (cart.getCartId() <= 0) {
                cartRepository.save(cart);
            }

        } catch (Exception re) {
            logger.error(" Error while executing the method addToCart " + re.getMessage() + re.getClass());
            throw re;
        } finally {
            logger.info("Exiting the method addToCart");

        }

    }

    public Integer cartCount(int userId) {
        logger.info("Entering Method cartCount  ");
        Integer cartCount = null;
        try {
            cartCount = cartRepository.cartCountById(new Integer(userId));
        } catch (Exception re) {
            logger.error(" Error while executing the method cartCount " + re.getMessage() + re.getClass());
            throw re;
        } finally {
            logger.info("Exiting the method cartCount");

        }
        return cartCount;
    }

    public List < CartProducts > cartDetails(int userId) {
        logger.info("Entering Method cartCount");
        List < CartProducts > cartProudctsResponse = new ArrayList < CartProducts > ();
        try {
            List cartProductsList = cartRepository.findAllById(new Integer(userId));
            if (cartProductsList != null && cartProductsList.size() > 0) {
                Iterator < Object > it = cartProductsList.iterator();
                while (it.hasNext()) {
                    Object[] row = (Object[]) it.next();
                    CartProducts cartProductsObj = new CartProducts();
                    cartProductsObj.setCartId((Integer) row[0]);
                    cartProductsObj.setUserId((Integer) row[1]);
                    cartProductsObj.setProductId((Integer) row[2]);
                    cartProductsObj.setQty((Integer) row[3]);
                    Optional < Product > productObj = productRepository.findById(cartProductsObj.getProductId());
                    cartProductsObj.setProducts(productObj.get());
                    cartProudctsResponse.add(cartProductsObj);
                }

            }

        } catch (Exception re) {
            logger.error(" Error while executing the method cartCount " + re.getMessage() + re.getClass());
            throw re;
        } finally {
            logger.info("Exiting the method cartCount");

        }
        return cartProudctsResponse;
    }

    public void deleteCart(int cartId) {
        logger.info("Entering Method deleteCart  ");
        try {
            if (cartId > 0) {
                cartRepository.deleteById(cartId);
            }

        } catch (Exception re) {
            logger.error(" Error while executing the method deleteCart " + re.getMessage() + re.getClass());
            throw re;
        } finally {
            logger.info("Exiting the method deleteCart");

        }
    }

	public void updateCart(int cartId, int qty) {
        logger.info("Entering Method updateCart  ");
        try {
            if (cartId > 0) {
                Optional<Cart> cartObj = cartRepository.findById(cartId);
                cartObj.get().setQty(qty);
                cartRepository.save(cartObj.get());
            }

        } catch (Exception re) {
            logger.error(" Error while executing the method updateCart " + re.getMessage() + re.getClass());
            throw re;
        } finally {
            logger.info("Exiting the method updateCart");

        }
	}


}