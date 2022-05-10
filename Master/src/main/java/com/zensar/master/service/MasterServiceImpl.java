package com.zensar.master.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.master.dto.MasterDto;
import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;
import com.zensar.master.repository.MasterCategory;
import com.zensar.master.repository.MasterStatus;

@Service
public class MasterServiceImpl implements MasterService{
	@Autowired
	private MasterCategory masterCategories;
	@Autowired
	private MasterStatus masterStatus;
	
	private ModelMapper modelMapper=new ModelMapper();
	

	  static List<Category> userDetails = new ArrayList<Category>();
	  
	  static { userDetails.add(new Category(1, "Furniture"));
	  userDetails.add(new Category(2, "cars")); userDetails.add(new
	  Category(3, "mobiles")); userDetails.add(new Category(4,
	  "real estate")); userDetails.add(new Category(5, "sports")); }
	  
	  static List<Status> userStatus = new ArrayList<Status>();
	  
	  static { userStatus.add(new Status(1, "OPEN")); userStatus.add(new
	  Status(2, "CLOSED"));
	  
	  
	  }
	 

	  
	  @Override
		public List<MasterDto> findOlxByCategory(String categ) {
		  List<Category> findcategory=masterCategories.findOlxByCategory(categ);
		  List<MasterDto> olxResponses = new ArrayList<>();
		  for(Category st:findcategory) {
			  //OlxMasterDto mapToResponse = mapToResponse(st);
			 MasterDto response=modelMapper.map(st, MasterDto.class);
		  olxResponses.add(response);
		  }

		  return olxResponses;
		}
	  
	  @Override
		public List<MasterDto> findOlxByStatus(String statusList) {
		  List<Status> findStatus=masterStatus.findOlxByStatus(statusList);
		  List<MasterDto> olxResponses = new ArrayList<>();
		  for(Status st:findStatus) {
			  //OlxMasterDto mapToResponse = mapToResponse(st);
			  MasterDto response=modelMapper.map(st, MasterDto.class);
		  olxResponses.add(response);
		  }

		  return olxResponses;
		}


	@Override
	public List<MasterDto> getAllAdd(int pageNumber,int pageSize) {
		List<Category> ListOlx = masterCategories.findAll();
		
		List<MasterDto> olxResponses = new ArrayList<>();

		for (Category olx : userDetails) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			MasterDto response=modelMapper.map(olx, MasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	@Override
	public List<MasterDto> getStatusList(int pageNumber,int pageSize) {
		
		List<Status> ListStatus = masterStatus.findAll();
	

		List<MasterDto> olxResponses = new ArrayList<>();

		for (Status olx : userStatus) {
			//OlxResponse mapToResponse = mapToResponse(olx);
		MasterDto response=modelMapper.map(olx, MasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	
	/*static List<Category> categories=new ArrayList<Category>();
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
	}*/

	
	
}
