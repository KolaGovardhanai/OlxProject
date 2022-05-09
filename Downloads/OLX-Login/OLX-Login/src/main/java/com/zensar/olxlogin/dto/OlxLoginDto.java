package com.zensar.olxlogin.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxLoginDto {
	private long id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	private long Phone;
	
}
