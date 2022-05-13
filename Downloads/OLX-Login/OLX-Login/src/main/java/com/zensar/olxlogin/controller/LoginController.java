package com.zensar.olxlogin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxlogin.Service.OlxLoginService;
import com.zensar.olxlogin.dto.OlxLoginDto;
import com.zensar.olxlogin.entity.OlxLogin;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	private OlxLoginService olxLoginService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<OlxLoginDto> createOlxUser(@RequestBody OlxLoginDto olx,
			@RequestHeader("auth-token") String token) {
		System.out.println("Hi");
		OlxLoginDto olxResult = olxLoginService.createOlxUser(olx, token);
		if (olxResult == null) {
			return new ResponseEntity<OlxLoginDto>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<OlxLoginDto>(olxResult, HttpStatus.CREATED);
		}
	}

	@GetMapping("/user")
	public List<OlxLoginDto> getAllUser(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,

			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return olxLoginService.getAllUser(pageNumber, pageSize);

	}

	// @PostMapping
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
	public String signInDetails(@RequestBody String userName, @RequestBody String password,
			@RequestHeader("auth-token") String token) {
		return olxLoginService.signInDetails(userName, password, token);

	}

	@DeleteMapping("/user/logout/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		return olxLoginService.deleteUser(userId);

	}

}
