package com.zensar.olxlogin.Service;

import java.util.List;

import com.zensar.olxlogin.dto.OlxLoginDto;
import com.zensar.olxlogin.entity.OlxLogin;

public interface OlxLoginService {
	List<OlxLoginDto> getAllUser(int pageNumber, int pageSize);

	String signInDetails(String userName, String password, String token);

	OlxLoginDto createOlxUser(OlxLoginDto olx, String token);

	String deleteUser(Long userId);

	List<OlxLoginDto> findOlxByName(String name);

}
