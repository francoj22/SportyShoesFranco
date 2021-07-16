package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserDao userDao;

	public void registerUser(User user)  throws Exception{
		logger.info("Entering Method registerUser");
		try {
			userDao.registerUser(user);
		}catch(Exception e){
			logger.error("Error While executing the registerUser "+ e.getMessage());
			throw e;
		}finally {
			logger.info("Exiting the method registerUser");
		}
		
	}
	
	public List<User> loginUser(User user)  throws Exception{
		logger.info("Entering Method loginUser");
		try {
			return userDao.loginUser(user);
		}catch(Exception e){
			logger.error("Error While executing the loginUser "+ e.getMessage());
			throw e;
		}finally {
			logger.info("Exiting the method loginUser");
		}
		
	}

	public void updatePassword(User request) throws Exception {
		logger.info("Entering Method updatePassword");
		try {
			userDao.updatePassword(request);
		}catch(Exception e){
			logger.error("Error While executing the updatePassword "+ e.getMessage());
			throw e;
		}finally {
			logger.info("Exiting the method updatePassword");
		}
	}

}