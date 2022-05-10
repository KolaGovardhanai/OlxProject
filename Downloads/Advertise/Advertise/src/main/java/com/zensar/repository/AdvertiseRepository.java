package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Advertise;
import com.zensar.service.OlxAdvertise;

public interface AdvertiseRepository extends JpaRepository<Advertise,Integer>{
	@Query(value="select * from olx_adverties where category=:categ",nativeQuery=true)
	List<Advertise> findOlxByCategory(@Param("categ") String categ);
}
