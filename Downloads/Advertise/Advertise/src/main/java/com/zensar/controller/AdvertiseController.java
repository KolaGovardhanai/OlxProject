package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Advertise;
import com.zensar.service.OlxAdvertise;
@RestController
public class AdvertiseController {
	@Autowired
	private OlxAdvertise olxAdvertise;
	
	@GetMapping(value="/advertises",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public List<Advertise> getAllUsers(@RequestHeader("userName") String userName,@RequestHeader("password") String password)
	 { 
		return olxAdvertise.getAllUsers(userName, password);
	}
	@GetMapping
	@RequestMapping(value = "/user/advertise", method = RequestMethod.GET)
	public List<Advertise> getAllCategories(@RequestHeader("userName") String username,@RequestHeader("password") String password) {
	return olxAdvertise.getAllCategories(username, password);
	}
    @RequestMapping(value="/user/advertise/{Id}", method=RequestMethod.GET)
	public Advertise getSpecificAdvertisement(@PathVariable("Id") long id,@RequestHeader("userName") String username,@RequestHeader("password") String password) {
	
	return olxAdvertise.getSpecificAdvertisement(id, username, password);
	}

	@DeleteMapping("/user/advertise/{Id}")
	public boolean deleteSpecificAdvertise(@PathVariable("Id") long id,@RequestHeader("userName") String username,@RequestHeader("password") String password) { if(username.equals("anand")&&password.equals("anand123")) 
	{
     return olxAdvertise.deleteSpecificAdvertise(id, username, password);
	}
	return false;
	}

	@GetMapping(value="/advertise/search",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public List<Advertise> searchAdvertise() {
	return olxAdvertise.searchAdvertise();
    }
	@GetMapping(value="/advertise/{postId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Advertise> advertiseDetails(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
	return olxAdvertise.advertiseDetails(id, username, password);
	}
}
