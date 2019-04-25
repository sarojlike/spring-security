package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Transactional
	public long createUser(User user) {
		
		long newUserId = userDao.insertNewUser(user);
		return newUserId;
		
	}
	
	@Transactional
	public User findUserByLoginName(String loginName) {
		return userDao.selectUserByLoginName(loginName);
	}

}
