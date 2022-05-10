package com.zensar.olxlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.olxlogin.entity.OlxLogin;

public interface OlxRepository extends JpaRepository<OlxLogin,Long> {
	@Query(value="select * from olx where first_Name=:name",nativeQuery=true)
	List<OlxLogin> findOlxByName(@Param("name") String name);

}
