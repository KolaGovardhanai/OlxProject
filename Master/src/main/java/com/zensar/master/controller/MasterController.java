package com.zensar.master.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;
import com.zensar.master.service.MasterService;
@RestController
public class MasterController {
	
	@Autowired
	private MasterService masterService;
	
	@GetMapping(value="/advertise/category",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Category> getAllAdvertisementCategories() {
	return masterService.getAllAdverticeCategories();
	}



	@GetMapping(value="/advertise/status",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public List<Status> getAllAdvertisementStatus(){
	return masterService.getAllAdvertisementStatus();
	}

}
