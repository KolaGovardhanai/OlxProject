package com.zensar.service;

import java.util.List;

import com.zensar.dto.OlxAddDto;
import com.zensar.entity.Advertise;

public interface OlxAdvertise {

	/*List<Advertise> getAllUsers(String userName,String password);
	 List<Advertise> getAllCategories( String username, String password);
	 Advertise getSpecificAdvertisement( long id, String username,String password);
	 boolean deleteSpecificAdvertise( long id,String username, String password);
	 List<Advertise> searchAdvertise();
	 List<Advertise> advertiseDetails( long id, String username, String password);*/
	OlxAddDto createOlxUser(OlxAddDto olx, String token);
	List<OlxAddDto> getAll();
	OlxAddDto getSpecificAdd(int id);
	OlxAddDto updateStock(int id, OlxAddDto olxrequest);
	String deleteUser(int id);
	
	List<OlxAddDto> findOlxByCategory(String categ);
}
