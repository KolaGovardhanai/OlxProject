package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.OlxAddDto;
import com.zensar.entity.Advertise;
import com.zensar.repository.AdvertiseRepository;
@Service
public class OlxAdvertiseImpl implements OlxAdvertise{
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	private ModelMapper modelMapper =  new ModelMapper();
	Advertise advertise = new Advertise();
	
	@Override
	public List<OlxAddDto> findOlxByCategory(String categ) {
		 List<Advertise> findcategory=advertiseRepository.findOlxByCategory(categ);
		  List<OlxAddDto> olxResponses = new ArrayList<>();
		  for(Advertise st:findcategory) {
			  //OlxMasterDto mapToResponse = mapToResponse(st);
			  OlxAddDto response=modelMapper.map(st, OlxAddDto.class);
		  olxResponses.add(response);
		  }

		  return olxResponses;
	}
	@Override
	public OlxAddDto createOlxUser(OlxAddDto olxRequest, String token) {
		Advertise newOlx = modelMapper.map(olxRequest, Advertise.class);

		if (token.equals("ag66543")) {
			Advertise olx1 = advertiseRepository.save(newOlx);
			return modelMapper.map(olx1, OlxAddDto.class);

		} else {
			return null;
		}
	}

	@Override
	public List<OlxAddDto> getAll() {
		List<Advertise> ListOlx = advertiseRepository.findAll();
		//List<OlxAdverties> content = pageOlx.getContent();
		List<OlxAddDto> olxAdvertiseResponses = new ArrayList<>();
		for (Advertise stock : ListOlx) {
			OlxAddDto olx1 = modelMapper.map(stock, OlxAddDto.class);
			olxAdvertiseResponses.add(olx1);
		}
		return olxAdvertiseResponses;
	}

	@Override
	public OlxAddDto getSpecificAdd(int id) {
		/*
		 * OlxAdverties olx = new OlxAdverties(); if (olx.getId() == id) { return olx; }
		 * else { return null; }
		 */
		Advertise olxResponse = advertiseRepository.findById(id).get();
		return modelMapper.map(olxResponse, OlxAddDto.class);
	}

	@Override
	public OlxAddDto updateStock(int id, OlxAddDto olxrequest) {
		/*
		 * OlxAdverties availableAdd = getSpecificAdd(id);
		 * availableAdd.setUserName(olxAdverties.getUserName());
		 * availableAdd.setTitle(olxAdverties.getTitle());
		 * availableAdd.setPrice(olxAdverties.getPrice()); return olxAdverties;
		 */
		OlxAddDto olxResponse = getSpecificAdd(id);

		Advertise olx1 = modelMapper.map(olxrequest, Advertise.class);

		Advertise olx2 = advertiseRepository.save(olx1);
		return modelMapper.map(olx2, OlxAddDto.class);
	}

	@Override
	public String deleteUser(int id) {
		advertiseRepository.deleteById(id);
		return "Deleted by id"+id;
}
	/*static List<Advertise> advertises=new ArrayList<Advertise>();
	static {
	advertises.add(new Advertise(1,"Laptop Sale",54000,"Electronic Goods","Intel core 3 Sony Vaio","anand",2021,2022,"OPEN"));
	}*/
	/*@Override
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
	}*/
	
	
       }
