package com.eintern.orm.dao;

import com.eintrn.orm.entity.User;

public interface UserDAO {
	
	public boolean passCompare (String password, String passconf);
	
	public boolean saveUser (User user);
	
	public boolean authenticateUser(String username, String password);
	

	
}
