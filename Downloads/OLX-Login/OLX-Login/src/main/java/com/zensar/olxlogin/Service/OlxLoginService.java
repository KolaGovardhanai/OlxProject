package com.zensar.olxlogin.Service;

import java.util.List;




import com.zensar.olxlogin.entity.OlxLogin;

public interface OlxLoginService {
	
	List<OlxLogin> getAllUsers( String username, String password);
	OlxLogin registerUser(OlxLogin user);
	boolean logoutUser(long id1,String username, String password);
	String loginUser( OlxLogin user );
	
	}

