package com.zensar.olxlogin.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.olxlogin.entity.OlxLogin;
@Service
public class OlxLoginServiceImpl implements OlxLoginService {
	static List<OlxLogin> users=new ArrayList<OlxLogin>();
	static {
	users.add(new OlxLogin(1L,"Govardhani","k","govardhani","kola@123","g.kola@123",757698689));
	
	}
	@Override
	public List<OlxLogin> getAllUsers(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
			return users;
			}
		return null;
		
	}
	@Override
	public OlxLogin registerUser(OlxLogin user) {
		users.add(user);
		return user;
	}
	@Override
	public boolean logoutUser(long id, String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
			for(OlxLogin user:users) {
			if(user.getId()==id) {
			users.remove(user);
	     	return true;
			}
			}
		}
		return false;
	}
	@Override
	public String loginUser(OlxLogin user) {
		return user.getUserName()+"\n"+user.getPassword();
		
	}
	

}
