package com.xiang.registration.dao;

import com.xiang.registration.model.User;

public interface UserDao {
	public void save(User u);
	public boolean checkUserExisWithName(String username);
}
