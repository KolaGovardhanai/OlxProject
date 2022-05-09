package com.zensar.olxlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxlogin.entity.OlxLogin;

public interface OlxRepository extends JpaRepository<OlxLogin,Long> {
  
}
