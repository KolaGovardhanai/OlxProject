package com.zensar.olxlogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.olxlogin.dto.OlxLoginDto;
import com.zensar.olxlogin.entity.OlxLogin;
import com.zensar.olxlogin.repository.OlxRepository;

//import springfox.documentation.swagger2.mappers.ModelMapper;
@Service
public class OlxLoginServiceImpl implements OlxLoginService {
	@Autowired
	private OlxRepository olxRepository;
	
	//private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	private ModelMapper modelMapper;

	OlxLogin olx = new OlxLogin();
	
	  //static List<OlxLogin> userDetails = new ArrayList<Olx>();
	  
	 // static { userDetails.add(new Olx(1, "ram", "kola", "ramk",
	 // "ram@123", "ram123@gmail.com", 7785275649L)); }
	

	
	
	@Override
	public List<OlxLoginDto> findOlxByName(String name) {
		List<OlxLogin> findName=olxRepository.findOlxByName(name);
		List<OlxLoginDto> olxResponses = new ArrayList<>();
		for(OlxLogin st:findName) {
			//OlxDto mapToResponse = mapToResponse(st);
			OlxLoginDto response=modelMapper.map(st, OlxLoginDto.class);
			olxResponses.add(response);
		}
		
		return olxResponses;
	}
	
	
	
	@Override
	public List<OlxLoginDto> getAllUser( int pageNumber, int pageSize ) {
		Page<OlxLogin> listOlx = olxRepository.findAll( PageRequest.of(pageNumber, pageSize) );
		List<OlxLogin> page = listOlx.getContent();

		List<OlxLoginDto> olxResponses = new ArrayList<>();

		for (OlxLogin olx :page ) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			OlxLoginDto response=modelMapper.map(olx, OlxLoginDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	

	@Override
	public String signInDetails(String userName, String password, String token) {
		olx.setUserName("ram");
		olx.setPassword("ram123");
		if (token.equals("GK66612")) {
			if (olx.getUserName().equals("ankitag") && olx.getPassword().equals("ankita123")) {
				return "Login Successfull!!!";
			} else {
				return "Sorry, Authentication Failed!!!";
			}
		}
		return "Token is not valid";

	}

	@Override
	public OlxLoginDto createOlxUser(OlxLoginDto olxRequest, String token) {
		
      OlxLogin newOlx= modelMapper.map(olxRequest, OlxLogin.class);
		

		if (token.equals("ag66543")) {
			 OlxLogin olx1 = olxRepository.save(newOlx);
			return modelMapper.map(olx1, OlxLoginDto.class);

		} else {
			return null;
		}
	}

	@Override
	public String deleteUser(Long userId) {
		
		olxRepository.deleteById(userId);
		return "User info deleted with : "+userId;
		/*
		 * for (Olx olx : userDetails) { if (olx.getUserId() == userId) {
		 * userDetails.remove(olx); return "user deleted Successfully" + userId; } }
		 * return "Sorry user is not available";
		 */

	}



	/*static List<OlxLogin> users=new ArrayList<OlxLogin>();
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
		
	}*/
	

}
