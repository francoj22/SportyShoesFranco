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

import com.example.demo.entity.Category;
import com.example.demo.entity.MainParentCategory;
import com.example.demo.service.MainParentCategoryService;
import net.sf.json.JSONObject;


@RestController
@MultipartConfig
public class MainParentCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(MainParentCategoryController.class);
    
    @Autowired
    MainParentCategoryService mainParentCategoryService;

    
    @RequestMapping(method = RequestMethod.GET, value = "/getMainParentCategories", 
            produces = {
                MediaType.APPLICATION_JSON_VALUE
            })
        @ResponseBody
        public ResponseEntity < Object > getMainParentCategories() {
            logger.info("Entering into the method getMainParentCategories ");
            List < JSONObject > entities = new ArrayList < JSONObject > ();
            JSONObject entity = new JSONObject();
            try {
                List<MainParentCategory> mainParentCategoryList = mainParentCategoryService.getMainParentCategories();
                entity.put("success", "true");
                entity.put("mainParentCategoryList", mainParentCategoryList);
                entities.add(entity);

            } catch (Exception e) {
                logger.error("Error while executing the method getMainParentCategories " + e.getMessage());
                entity.put("failure", true);
                entity.put("message", e.getMessage());
                entities.add(entity);

            } finally {
                logger.info("Exiting the method getMainParentCategories");
            }

            return new ResponseEntity < Object > (entities, HttpStatus.OK);

        }





}