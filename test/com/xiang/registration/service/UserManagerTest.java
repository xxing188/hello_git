package com.xiang.registration.service;

import org.junit.Assert;

import org.junit.Test;

import com.xiang.registration.model.User;
import com.xiang.registration.service.impl.UserManagerImpl;


public class UserManagerTest {

	@Test
	public void testExists() {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("zhangsan");
		boolean exists = um.exists(u);
		Assert.assertEquals(true, exists);
	}

	@Test
	public void testAdd() {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("b");
		u.setPassword("b");
		boolean exists = um.exists(u);
		if(!exists){
		    um.add(u);
		    u.setUsername("b");
		    Assert.assertEquals(true, um.exists(u));
		}else{
			Assert.fail("没有加进去");
		}
	}

}
