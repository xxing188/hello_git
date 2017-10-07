package com.xiang.registration.service;

import com.xiang.registration.model.User;

public interface UserManager {

	boolean exists(User u);

	void add(User u);

}