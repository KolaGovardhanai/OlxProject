package com.zensar.olxlogin.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxLoginDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	private long Phone;

}
