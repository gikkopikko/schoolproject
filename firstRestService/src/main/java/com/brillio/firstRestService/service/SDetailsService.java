package com.brillio.firstRestService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.brillio.firstRestService.StudentDAO;
import com.brillio.firstRestService.entity.SDetailsDTO;

@Service
public class SDetailsService {
	@Autowired
	StudentDAO studentDAO;
    @Cacheable("sdetails")
    public List<SDetailsDTO> findAll(){
        List<SDetailsDTO> sdetails = studentDAO.findAll();

        return sdetails;
    }
}
