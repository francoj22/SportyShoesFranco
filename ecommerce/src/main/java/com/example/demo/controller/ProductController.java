package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import net.sf.json.JSONObject;


@RestController
@MultipartConfig
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    ProductService productService;
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView redirectToProductsView() {
    	logger.info("Entering Method method ");
        return new ModelAndView("products", "Message", "Redirecting to products");
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/getProducts", 
            produces = {
                MediaType.APPLICATION_JSON_VALUE
            })
        @ResponseBody
        public ResponseEntity < Object > getProducts() {
            logger.info("Entering into the method getProducts ");
            List < JSONObject > entities = new ArrayList < JSONObject > ();
            JSONObject entity = new JSONObject();
            try {
                List<Product> productsList = productService.getProducts();
                entity.put("success", "true");
                entity.put("productsList", productsList);
                entities.add(entity);

            } catch (Exception e) {
                logger.error("Error while executing the method getProducts " + e.getMessage());
                entity.put("failure", true);
                entity.put("message", e.getMessage());
                entities.add(entity);

            } finally {
                logger.info("Exiting the method getProducts");
            }

            return new ResponseEntity < Object > (entities, HttpStatus.OK);

        }


    


}