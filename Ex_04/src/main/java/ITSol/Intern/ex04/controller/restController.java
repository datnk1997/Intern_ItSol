package ITSol.Intern.ex04.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ITSol.Intern.ex04.dao.StudentDAO;
import ITSol.Intern.ex04.model.Student;

@RestController
public class restController {

	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Student> getStudent(){
		List<Student> list = studentDAO.findAll();
		return list;
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Optional<Student> getStudentById(@PathVariable("id")int id) {
		Optional<Student> list = studentDAO.findById(id);
		return list;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Student createStudent(@RequestBody Student student) {
		return studentDAO.save(student);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Student updateStudent(@RequestBody Student student) {
		return studentDAO.save(student);
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void deleteStudent(@PathVariable("id")int id) {
		studentDAO.deleteById(id);
	}
}
		