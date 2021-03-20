package com.rtest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtest.controller.UserController;
import com.rtest.domain.UserVO;
import com.rtest.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public UserVO login(UserVO userVo) {
		logger.info("login user service");
		return userMapper.login(userVo);
	}
	

}
