package com.brillio.firstRestService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import com.brillio.firstRestService.entity.SDetailsDTO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentEnrollment {
	@Autowired
	CrudController controller;
	SDetailsDTO student;
    String result;

    @Given("A student enrolls")
    public void aStudentEnrolls() {
        student = new SDetailsDTO();
    }

    @When("The data is collected")
    public void theDataIsCollected() {
        student.setSid("111");
        student.setFname("Alpha");
        student.setLname("Beta");
        student.setAddress("nowhere, 123");
        student.setDob("1991-05-05");
        result = controller.insertStudent(student);
    }

    @Then("Data is added in the database")
    public void dataIsAddedInTheDatabase() {
        assertEquals(result, "Data is Inserted");
    }


}
