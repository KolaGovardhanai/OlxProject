package com.zensar.service;

import java.util.List;

import com.zensar.dto.OlxAddDto;
import com.zensar.entity.Advertise;

public interface OlxAdvertise {

	OlxAddDto createOlxUser(OlxAddDto olx, String token);

	List<OlxAddDto> getAll();

	OlxAddDto getSpecificAdd(int id);

	OlxAddDto updateStock(int id, OlxAddDto olxrequest);

	String deleteUser(int id);

	List<OlxAddDto> findOlxByCategory(String categ);
}
