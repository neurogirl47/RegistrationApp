package com.eintern.orm.dao.impl;

import java.util.List;
import com.eintrn.orm.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.eintern.orm.dao.UserDAO;
import com.eintrn.orm.entity.User;

public class UserDAOImpl implements UserDAO{

		
Session session;
	
	public void Setup(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public boolean authenticateUser(String username, String password){
		
		Setup();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password));
				
				List data = criteria.list();
				
				System.out.println(data);
				
				if(data.size()==0)
					return false;
				else
					return true;
	}
	
	public boolean saveUser (User user){
		
		
		
		Setup();
		
		
		try{
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		}catch (Exception e){
			return false;
		}
		
		session.close();
		return true;
		
				
				
	}

	
	public boolean passCompare (String password, String passconf) {
		
			if(password.equals(passconf))
				return true;
			else
				return false;
	}

	

	
}
