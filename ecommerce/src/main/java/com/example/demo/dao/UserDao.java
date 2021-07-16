package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Repository
public class UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	UserRepository userRepository;
	
	public void registerUser(User user) throws Exception {
        logger.info("Entering Method registerUser ");
        try {
        	if(user.getUsersId() <= 0) {
    			userRepository.save(user);
        	}
			
        } catch (Exception re) {
        	logger.error(" Error while executing the method registerUser " + re.getMessage() + re.getClass());
            throw re;
        } finally {
        	logger.info("Exiting the method registerUser");

        }

	}
	

	public List<User> loginUser(User user) throws Exception {
        logger.info("Entering Method loginUser ");
        List<User> userList = new ArrayList<User> ();
        try {
        	userList = userRepository.findALL(user.getEmail(),user.getPassword());
        	
        } catch (Exception re) {
        	logger.error(" Error while executing the method loginUser " + re.getMessage() + re.getClass());
            throw re;
        } finally {
        	logger.info("Exiting the method loginUser");

        }
		return userList;

	}
	
	public void updatePassword(User user) throws Exception {
        logger.info("Entering Method updatePassword ");
        try {
        	if(user.getEmail()!=null && !user.getEmail().equals("")) {
    			userRepository.updatePassword(user.getEmail(), user.getPassword());
        	}
			
        } catch (Exception re) {
        	logger.error(" Error while executing the method updatePassword " + re.getMessage() + re.getClass());
            throw re;
        } finally {
        	logger.info("Exiting the method updatePassword");

        }

	}
	
}