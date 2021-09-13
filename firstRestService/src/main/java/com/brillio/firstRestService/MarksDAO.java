package com.brillio.firstRestService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brillio.firstRestService.entity.MarksDTO;

@Repository
public interface MarksDAO extends JpaRepository<MarksDTO, MarksId>{

	
	@Query(value="select a.sid, a.fname, b.tests, b.avgmarks from sdetails a join (select t1.sid, count(t1.testno) as tests, avg(t1.m1+t1.m2+t1.m3)/3 as avgmarks from marks t1 group by t1.sid) b on a.sid = b.sid;", nativeQuery=true)
	 public List<List<String>> getAvgMarks();
}
