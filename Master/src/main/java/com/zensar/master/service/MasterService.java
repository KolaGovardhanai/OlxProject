package com.zensar.master.service;

import java.util.ArrayList;
import java.util.List;

import com.zensar.master.dto.MasterDto;
import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

public interface MasterService {
	List<MasterDto> getAllAdd(int pageNumber, int pageSize);

	List<MasterDto> getStatusList(int pageNumber, int pageSize);

	List<MasterDto> findOlxByCategory(String categ);

	List<MasterDto> findOlxByStatus(String statusList);

}
