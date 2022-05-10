package com.zensar.master.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

public interface MasterStatus extends JpaRepository<Status,Long>{
	@Query(value="select * from olx_status_list where status=:statusList",nativeQuery=true)
	List<Status> findOlxByStatus(@Param("statusList") String statusList);
}
