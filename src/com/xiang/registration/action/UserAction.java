package com.xiang.registration.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiang.registration.model.User;
import com.xiang.registration.service.UserManager;
import com.xiang.registration.service.impl.UserManagerImpl;

public class UserAction extends ActionSupport {
	
	private UserManager um;
	
	private String username;
	private String password;
	private String password2;
	
	public UserAction(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		um = (UserManager)ctx.getBean("userManager");
	}
	
	public UserManager getUm() {
		return um;
	}

	public void setUm(UserManager um) {
		this.um = um;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		if(um.exists(u)){
			return "fail";
		}
		um.add(u);
		return "success";
		
		
	}
}
