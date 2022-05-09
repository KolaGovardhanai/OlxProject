package com.zensar.master.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

@Service
public class MasterServiceImpl implements MasterService{
	static List<Category> categories=new ArrayList<Category>();
	static {
	categories.add(new Category(1L,"Furniture"));
	categories.add(new Category(2L,"Cars"));
	categories.add(new Category(3L,"Mobiles"));
	categories.add(new Category(4L,"RealEstate"));
	categories.add(new Category(5L,"Sports"));
	}

	static List<Status> status=new ArrayList<Status>();
	static {
	status.add(new Status(1L,"open"));
	status.add(new Status(2L,"closed"));
	}


	@Override
	public List<Category> getAllAdverticeCategories() {
		return categories;
	}

	@Override
	public List<Status> getAllAdvertisementStatus() {
		return status;
	}

	
	
}
