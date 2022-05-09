package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Advertise;
@Service
public class OlxAdvertiseImpl implements OlxAdvertise{
	static List<Advertise> advertises=new ArrayList<Advertise>();
	static {
	advertises.add(new Advertise(1,"Laptop Sale",54000,"Electronic Goods","Intel core 3 Sony Vaio","anand",2021,2022,"OPEN"));
	}
	@Override
	public List<Advertise> getAllUsers(String userName, String password) {
		if (userName.equals("anand") && password.equals("anand123")) {
			return advertises;
		}
		return null;
	}
	@Override
	public List<Advertise> getAllCategories(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
		return advertises;
		}
		return null;
	}
	@Override
	public Advertise getSpecificAdvertisement(long id, String username, String password) {
		if(username.equals("anand")&&password.equals("anand123"))
		{ 
			for (Advertise advertise:advertises) 
			{
				if (advertise.getId() == id) 
				{
		return advertise;
		}
		}
		}
		return null;
	}
	@Override
	public boolean deleteSpecificAdvertise(long id, String username, String password) {
		for(Advertise advertise:advertises) {
		if(advertise.getId()==id) {
		advertises.remove(advertise);
		return true;
		} 
		}
		return false;
		}
	@Override
	public List<Advertise> searchAdvertise() {
		return advertises;
	}
	@Override
	public List<Advertise> advertiseDetails(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
		for(Advertise ads:advertises) {
		if(ads.getId()==id) {
		return advertises;
		}
		}
		}
		return null;
	}

	
       }
