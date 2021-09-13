package com.brillio.firstRestService.entity;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="sdetails")
public class SDetails1DTO {
	@Id
	private String sid;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String dob;
	@Column
	private String address;
	
	@OneToMany
    @JoinColumn(name = "sid")
	private List<MarksDTO> marks;
	
	public List<MarksDTO> getMarks() {
		return marks;
	}
	public void setMarks(List<MarksDTO> marks) {
		this.marks = marks;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
