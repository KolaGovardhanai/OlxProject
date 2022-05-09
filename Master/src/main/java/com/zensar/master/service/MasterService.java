package com.zensar.master.service;

import java.util.ArrayList;
import java.util.List;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

public interface MasterService {
	//static List<Category> category=new ArrayList<Category>();
	List<Category> getAllAdverticeCategories();
	List<Status> getAllAdvertisementStatus();
	
	
	
	
}
