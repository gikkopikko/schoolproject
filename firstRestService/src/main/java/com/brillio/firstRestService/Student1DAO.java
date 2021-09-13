package com.brillio.firstRestService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.firstRestService.entity.SDetails1DTO;

@Repository
public interface Student1DAO extends JpaRepository<SDetails1DTO, String>{

}
