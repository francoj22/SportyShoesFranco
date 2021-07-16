package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.constants.SessionConstants;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import net.sf.json.JSONObject;


@RestController
@MultipartConfig
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/registerUsers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        })
    @ResponseBody
    public ResponseEntity < Object > registerUsers(@ModelAttribute("registration_form") User request) throws IOException {
        logger.info("Entering into the method registerUsers ");
        List < JSONObject > entities = new ArrayList < JSONObject > ();
        JSONObject entity = new JSONObject();
        try {

            userService.registerUser(request);

            entity.put("success", "true");
            entity.put("message", "Successfully Students Values Inserted");
            entities.add(entity);

        } catch (Exception e) {
            logger.error("Error while executing the method registerUser " + e.getMessage());
            if (e.getMessage().contains("ConstraintViolationException")) {
                entity.put("failure", true);
                entity.put("message", "Email Id or Phone Number Already Registered");
            } else {
                entity.put("failure", true);
                entity.put("message", e.getMessage());
            }
            entities.add(entity);

        } finally {
            logger.info("Exiting the method registerUsers");
        }

        return new ResponseEntity < Object > (entities, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/loginUser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        })
    @ResponseBody
    public ResponseEntity < Object > loginUser(@ModelAttribute("login_account") User request) {
        logger.info("Entering into the method loginUser ");
        List < JSONObject > entities = new ArrayList < JSONObject > ();
        JSONObject entity = new JSONObject();
        try {

            List<User> userList = userService.loginUser(request);
            if (userList.size() != 0) {
            	this.setSessionValuesForUser(userList.get(0));
            	entity.put("success", "true");
                entity.put("message", "User LoggedIn Successfully");
            } else {
                entity.put("failure", "true");
                entity.put("message", "Invalid Credentials, Kindly Check!");
            }
            entities.add(entity);

        } catch (Exception e) {
            logger.error("Error while executing the method loginUser " + e.getMessage());
            entity.put("failure", true);
            entity.put("message", e.getMessage());
            entities.add(entity);

        } finally {
            logger.info("Exiting the method loginUser");
        }

        return new ResponseEntity < Object > (entities, HttpStatus.OK);

    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/updatePassword", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                MediaType.APPLICATION_JSON_VALUE
            })
        @ResponseBody
        public ResponseEntity < Object > updatePassword(@ModelAttribute("forgotpassword_form") User request) {
            logger.info("Entering into the method updatePassword ");
            List < JSONObject > entities = new ArrayList < JSONObject > ();
            JSONObject entity = new JSONObject();
            try {

                userService.updatePassword(request);
                entity.put("success", "true");
                entity.put("message", "Successfully Password Updated");
                entities.add(entity);

            } catch (Exception e) {
                logger.error("Error while executing the method updatePassword " + e.getMessage());
                entity.put("failure", true);
                entity.put("message", e.getMessage());
                entities.add(entity);

            } finally {
                logger.info("Exiting the method updatePassword");
            }

            return new ResponseEntity < Object > (entities, HttpStatus.OK);

        }

    
    private void setSessionValuesForUser(User userResponse) {
    	logger.info("Entering Method setSessionValuesForUser ");
        try {
        	ServletRequestAttributes attr = (ServletRequestAttributes)  RequestContextHolder.currentRequestAttributes();
        	HttpSession session= attr.getRequest().getSession(true);
        	session.setAttribute("USER_NAME", userResponse.getFirstName() +" "+ userResponse.getLastName());
        	session.setAttribute("USER_ID", userResponse.getUsersId());
        	session.setAttribute(SessionConstants.SESSION_VITAL_USER, userResponse);
        } catch (Exception e) {
        	logger.error(" Error while executing the method setSessionValuesForUser " + e.getMessage() + e.getClass());
            throw e;
        } finally {
        	logger.info("Exiting the method setSessionValuesForUser");
        }

    }
    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public ModelAndView redirectToForgotPasswordView() {
    	logger.info("Entering Method redirectToForgotPasswordView ");
        return new ModelAndView("forgotPassword", "Message", "Redirecting to forgot password");
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView redirectToIndexView() {
    	logger.info("Entering Method redirectToIndexView ");
        return new ModelAndView("index", "Message", "Redirecting to Index");
    }
    
    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public ModelAndView logOut() {
    	logger.info("Entering Method logOut ");
    	this.removeSessionValuesForUser();
        return new ModelAndView("index", "Message", "Redirecting to Index");
    }
    
    @RequestMapping(value = "/documentation", method = RequestMethod.GET)
    public ModelAndView redirectToDocumentationView() {
    	logger.info("Entering Method redirectToDocumentationView ");
        return new ModelAndView("templates/documentation/index", "Message", "Redirecting to Index");
    }

    private void removeSessionValuesForUser() {
    	logger.info("Entering Method removeSessionValuesForUser ");
        try {
        	ServletRequestAttributes attr = (ServletRequestAttributes)  RequestContextHolder.currentRequestAttributes();
        	HttpSession session= attr.getRequest().getSession(true);
        	session.removeAttribute("USER_NAME");
        	session.removeAttribute("USER_ID");
        	session.removeAttribute(SessionConstants.SESSION_VITAL_USER);
        } catch (Exception e) {
        	logger.error(" Error while executing the method removeSessionValuesForUser " + e.getMessage() + e.getClass());
            throw e;
        } finally {
        	logger.info("Exiting the method removeSessionValuesForUser");
        }

    }





}