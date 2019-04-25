package com.example.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository("userDao")
public class UserDao {

	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    private Session getSession(){
	        return sessionFactory.getCurrentSession();
	    }
	
	
	    public long insertNewUser(User user) {
	    	long id=0;
	    	Serializable save = getSession().save(user);
	    	if(save !=null) {
	    		 id = Long.parseLong(save.toString());
	    	}
	    	return id;
	    }
	    
	    
	    public User updateUser(User user) {
			
	    	User persitentUser = selectUserById(user);
			persitentUser.setLoginName(user.getLoginName());
			persitentUser.setName(user.getName());
			persitentUser.setPassword(user.getPassword());
			getSession().update(persitentUser);
			return persitentUser;
			
		}
	    
	    public User selectUserById(User user) {
	    	User persitentUser = getSession().get(User.class, user.getId());
	    	return persitentUser;
		}

		public User selectUserByLoginName(String loginName) {
	    	 Query query = getSession().createQuery("from User u where u.loginName=:loginName");
	    	 query.setParameter("loginName", loginName);
	    	 User uniqueResult =(User) query.uniqueResult();
	    	return uniqueResult;
	    }
	    
	    
	    
}
