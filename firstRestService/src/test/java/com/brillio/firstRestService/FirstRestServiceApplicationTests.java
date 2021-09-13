package com.brillio.firstRestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.brillio.firstRestService.entity.SDetailsDTO;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

class FirstRestServiceApplicationTests {
	@Autowired
	MyController controller;

	@Autowired
	CrudController crudController;

	@Test
	@Order(1)
	public void testDTOAvailableOrNot() {

		try {
			SDetailsDTO sdetailsDTO = new SDetailsDTO();
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(2)
	public void testDTOAvailableOrNot1() {

		try {
			SDetailsDTO sdetailsDTO = new SDetailsDTO();
			sdetailsDTO.getAddress();
			sdetailsDTO.getFname();
			sdetailsDTO.getLname();
			sdetailsDTO.getDob();
			sdetailsDTO.getSid();
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(3)
	public void testController() {

		try {
			List<SDetailsDTO> students = controller.getStudents();
			assertNotNull(students);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(4)
	public void testController1() {

		try {
			List<SDetailsDTO> students = controller.getStudents();
			assertEquals(students.get(0).getSid(), "101");
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(4)
	public void testController2() {

		try {
			Optional<SDetailsDTO> students = controller.getAnyStudent("101");
			assertEquals(students.get().getSid(), "101");
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	@Order(5)
	public void testController3() {
		try {
			Optional<SDetailsDTO> students = controller.getAnyStudent("5000");
			assertEquals(students, Optional.empty());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(6)
	public void testCrudControllerInsertion() {
		try {
			SDetailsDTO student = new SDetailsDTO();
			student.setSid("150");
			student.setAddress("abc, def");
			student.setFname("Gamma");
			student.setLname("Delta");
			student.setDob("1991-01-01");
			String result = crudController.insertStudent(student);
			assertEquals(result, "Data is Inserted");
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(7)
	public void testCrudControllerUpdate() {
		try {
			SDetailsDTO student = new SDetailsDTO();
			student.setSid("150");
			student.setAddress("abc, def");
			student.setFname("Zeta");
			student.setLname("Delta");
			student.setDob("1991-01-01");
			String result = crudController.updateStudent(student);
			assertEquals(result, "Data is Updated");
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(8)
	public void testCrudControllerDelete() {
		try {

			String result = crudController.deleteStudent("150");
			assertEquals(result, "Data is Deleted");
		} catch (Exception e) {
			fail();
		}
	}

}
