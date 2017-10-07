package com.xiang.registration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.xiang.registration.dao.UserDao;
import com.xiang.registration.model.User;

@Component("userDao")
public class UserpDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User u) {
		hibernateTemplate.save(u);
	}

	@Override
	public boolean checkUserExisWithName(String username) {
		List<User> users = hibernateTemplate.find("from User u where u.username='"+ username +"'");
		
		if(users != null && users.size() > 0){
			return true;
		}
		return false;
		
	}

	

}
