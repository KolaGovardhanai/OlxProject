package com.zensar.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.master.entity.Category;

public interface MasterCategory extends JpaRepository<Category, Integer>{
	@Query(value="select * from olx_categories where category=:categ",nativeQuery=true)
	List<Category> findOlxByCategory(@Param("categ") String categ);
}
