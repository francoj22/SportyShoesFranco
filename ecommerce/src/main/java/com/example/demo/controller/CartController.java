package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProducts;
import com.example.demo.service.CartService;
import net.sf.json.JSONObject;


@RestController
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value = "/addToCart",
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        })
    @ResponseBody
    public ResponseEntity < Object > addToCart(@RequestBody String addToCartDetails) throws IOException {
        logger.info("Entering into the method addToCart ");
        List < JSONObject > entities = new ArrayList < JSONObject > ();
        JSONObject entity = new JSONObject();
        Cart cart = new Cart();
        try {

            JSONParser parser = new JSONParser(addToCartDetails);
            HashMap < String, String > obj = (HashMap < String, String > ) parser.parse();
            String productId = obj.get("product_id");
            String userId = obj.get("user_id");
            String qty = obj.get("qty");
            String productSize = obj.get("size");
            String productColor = obj.get("color");

            if (productId != null && !productId.equals("")) {
                cart.setProductId(Integer.parseInt(productId));
            }

            if (userId != null && !userId.equals("")) {
                cart.setUserId(Integer.parseInt(userId));
            }

            if (qty != null && !qty.equals("")) {
                cart.setQty(Integer.parseInt(qty));
            }

            if (productSize != null && !productSize.equals("")) {
                cart.setProductSize(productSize);
            }

            if (productColor != null && !productColor.equals("")) {
                cart.setProductColor(productColor);
            }

            cartService.addToCart(cart);

            entity.put("success", "true");
            entity.put("message", "Item Successfully added to the Cart");
            entities.add(entity);

        } catch (Exception e) {
            logger.error("Error while executing the method addToCart " + e.getMessage());
            if(e.getMessage().contains("ConstraintViolationException")) {
                entity.put("failure", true);
                entity.put("message", "Item already added in the Cart! Kindly Check");
            }else {
                entity.put("failure", true);
                entity.put("message", e.getMessage());
            }
            entities.add(entity);

        } finally {
            logger.info("Exiting the method addToCart");
        }

        return new ResponseEntity < Object > (entities, HttpStatus.OK);

    }


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView redirectToCartView() {
        logger.info("Entering Method redirectToCartView ");
        return new ModelAndView("cart", "Message", "Redirecting to redirectToCartView");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cartCount",
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        })
    @ResponseBody
    public ResponseEntity < Object > cartCount(@RequestBody String userId) throws IOException {
        logger.info("Entering into the method cartCount ");
        List < JSONObject > entities = new ArrayList < JSONObject > ();
        JSONObject entity = new JSONObject();
        Integer cartCount = null;
        try {
        	
            String[] userIdVal = userId.split("=");

        	cartCount = cartService.cartCount(Integer.parseInt(userIdVal[1]));

            entity.put("success", "true");
            entity.put("cartCount", cartCount);
            entities.add(entity);

        } catch (Exception e) {
            logger.error("Error while executing the method addToCart " + e.getMessage());
            entity.put("failure", true);
            entity.put("message", e.getMessage());
            entities.add(entity);

        } finally {
            logger.info("Exiting the method addToCart");
        }

        return new ResponseEntity < Object > (entities, HttpStatus.OK);

    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/cartDetails",
            produces = {
                MediaType.APPLICATION_JSON_VALUE
            })
        @ResponseBody
        public ResponseEntity < Object > cartDetails(@RequestBody String userId) throws IOException {
            logger.info("Entering into the method cartDetails ");
            List < JSONObject > entities = new ArrayList < JSONObject > ();
            JSONObject entity = new JSONObject();
          
            try {
            	
                String[] userIdVal = userId.split("=");

                List<CartProducts> cartProducts =  cartService.cartDetails(Integer.parseInt(userIdVal[1]));

                entity.put("success", "true");
                entity.put("cartList", cartProducts);
                entities.add(entity);

            } catch (Exception e) {
                logger.error("Error while executing the method cartDetails " + e.getMessage());
                entity.put("failure", true);
                entity.put("message", e.getMessage());
                entities.add(entity);

            } finally {
                logger.info("Exiting the method cartDetails");
            }

            return new ResponseEntity < Object > (entities, HttpStatus.OK);

        }
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/deleteCart",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                MediaType.APPLICATION_JSON_VALUE
            })
        @ResponseBody
        public ResponseEntity < Object > deleteCart(@RequestParam("cart_id") int cartId) {
            logger.info("Entering into the method deleteCart ");
            JSONObject entity = new JSONObject();
            try {
                cartService.deleteCart(cartId);
                entity.put("success", "true");
                entity.put("message", "Cart Deleted Successfully");

            } catch (Exception e) {
                logger.error("Error while executing the method deleteCart " + e.getMessage());
                entity.put("failure", true);
                entity.put("message", e.getMessage());

            } finally {
                logger.info("Exiting the method deleteCart");
            }

            return new ResponseEntity < Object > (entity, HttpStatus.OK);

        }
    
    @RequestMapping(method = RequestMethod.POST, value = "/updateCart",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                MediaType.APPLICATION_JSON_VALUE
            })
        @ResponseBody
        public ResponseEntity < Object > updateCart(@RequestParam("cart_id") int cartId,@RequestParam("qty") int qty) {
            logger.info("Entering into the method updateCart ");
            JSONObject entity = new JSONObject();
            try {
                cartService.updateCart(cartId,qty);
                entity.put("success", "true");
                entity.put("message", "Cart Qty Updated Successfully");

            } catch (Exception e) {
                logger.error("Error while executing the method updateCart " + e.getMessage());
                entity.put("failure", true);
                entity.put("message", e.getMessage());

            } finally {
                logger.info("Exiting the method updateCart");
            }

            return new ResponseEntity < Object > (entity, HttpStatus.OK);

        }







}