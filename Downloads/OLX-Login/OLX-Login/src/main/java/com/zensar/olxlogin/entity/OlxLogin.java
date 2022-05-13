package com.zensar.olxlogin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity(name="myOlx")
@Table(name = "OlxLogin")
public class OlxLogin {
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
