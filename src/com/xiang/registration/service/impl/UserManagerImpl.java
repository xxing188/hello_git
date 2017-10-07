package com.xiang.registration.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.xiang.registration.dao.UserDao;
import com.xiang.registration.dao.impl.UserpDaoImpl;
import com.xiang.registration.model.User;
import com.xiang.registration.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	/* (non-Javadoc)
	 * @see com.xiang.registration.service.impl.UserManager#exists(com.xiang.registration.model.User)
	 */
	@Override
	public boolean exists(User u){
		return userDao.checkUserExisWithName(u.getUsername());
		
	}
	/* (non-Javadoc)
	 * @see com.xiang.registration.service.impl.UserManager#add(com.xiang.registration.model.User)
	 */
	@Override
	public void add(User u){
		userDao.save(u);
	}
}
