package com.zensar.master.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String category;
	  private int statusId;
	  private String status;
}
