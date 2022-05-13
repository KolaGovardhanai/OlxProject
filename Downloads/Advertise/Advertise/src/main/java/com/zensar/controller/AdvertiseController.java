package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.OlxAddDto;
import com.zensar.entity.Advertise;
import com.zensar.service.OlxAdvertise;

@RestController
public class AdvertiseController {
	@Autowired
	private OlxAdvertise olxAdvertise;

	@RequestMapping(value = "/advertise", method = RequestMethod.POST)
	public ResponseEntity<OlxAdvertise> createOlxUser(@RequestBody OlxAddDto olx,
			@RequestHeader("auth-token") String token) {
		OlxAddDto olxAdd = olxAdvertise.createOlxUser(olx, token);
		if (olxAdd == null) {
			return new ResponseEntity<OlxAdvertise>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<OlxAdvertise>(HttpStatus.CREATED);
		}
	}

	@GetMapping(value = "/user/advertise")
	public List<OlxAddDto> getAll() {

		return olxAdvertise.getAll();
	}

	@RequestMapping(value = "user/advertise/{id}", method = RequestMethod.GET)
	public OlxAddDto getSpecificAdd(@PathVariable("id") int id) {
		return olxAdvertise.getSpecificAdd(id);

	}

	@PutMapping("/advertise/{id}")
	public OlxAddDto updateStock(@PathVariable("id") int id, @RequestBody OlxAddDto olxAdverties) {
		return olxAdvertise.updateStock(id, olxAdverties);
	}

	@DeleteMapping("/user/advertise/{id}")
	public String deleteUser(@PathVariable int id) {
		return olxAdvertise.deleteUser(id);

	}

}
