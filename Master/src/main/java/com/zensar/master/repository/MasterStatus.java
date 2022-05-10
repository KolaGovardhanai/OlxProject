package com.zensar.master.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

public interface MasterRepository extends JpaRepository<Status,Long>{

}
