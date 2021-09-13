package com.brillio.firstRestService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brillio.firstRestService.entity.SDetailsDTO;

@Repository
public interface StudentDAO extends JpaRepository<SDetailsDTO, String>{
	public Optional<SDetailsDTO> findByFname(String fname);
	public List<SDetailsDTO> findAllByFnameAndLname(String fname,String lname);
	
	@Query(value="Select t1.sid, t1.fname, t1.lname, t3.cityname, t4.statename FROM sdetails t1 JOIN connectcity t2 on t1.sid=t2.sid JOIN city t3 on t2.citycode=t3.citycode JOIN state t4 ON t3.statecode=t4.statecode", nativeQuery=true)
	 public List<List<String>> getNameAndCity();
	 
	
}
