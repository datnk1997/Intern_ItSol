package ITSol.Intern.ex04.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ITSol.Intern.ex04.dao.AccountDAO;
import ITSol.Intern.ex04.dao.StudentDAO;
import ITSol.Intern.ex04.model.Student;

@Controller
public class controller {
	@Autowired
	private AccountDAO accountdao;
	@Autowired
	private StudentDAO studentdao;
	private static final Logger logger = Logger.getLogger(controller.class);

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
	public String checkAccount( Model model,  @RequestParam("account") String account,
			@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email) {
		boolean rs = accountdao.existsById(account);
		if (rs == false) {
			model.addAttribute("mess", "Account not Exist !!! ");
			return "index";
		} else {
			logger.fatal("Account: " + account);
			logger.fatal("FirstName: " + firstname);
			logger.fatal("LastName: " + lastname);
			logger.fatal("Email: " + email);
			return "redirect:/StudentScreen";

		}
	}

	@RequestMapping(value = "/StudentScreen")
	public String getAllStudent(Model model) {
		List<Student> ls = studentdao.findAll();
		model.addAttribute("liststu", ls);
		return "/StudentScreen";
	}

	@RequestMapping(value = "/createStudent", method = RequestMethod.GET)
	public String createStudent() {
		return "/createStudent";
	}

	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public String createStudent(Model model, @RequestParam("fname") String name, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("classs") String classs,
			@RequestParam("note") String note) {
		Student st = new Student(name, email, phone, classs, note);
		studentdao.save(st);
		return "redirect:StudentScreen";
	}

	@RequestMapping(value = "/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentdao.deleteById(id);
		return "redirect:/StudentScreen";
	}

	@RequestMapping(value = "/editStudent/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") int id, Model model) {
		Optional<Student> st = studentdao.findById(id);
		if (st.isPresent()) {
			model.addAttribute("student", st.get());
		}
		return "/editStudent";
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.POST)
	public String editStudent(Model model, @RequestParam("id") int id, @RequestParam("fname") String name,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("classs") String classs, @RequestParam("note") String note) {
		Student st = new Student(id, name, email, phone, classs, note);
		studentdao.save(st);
		return "redirect:/StudentScreen";
	}

	@RequestMapping(value = "/searchStudent")
	public String searchStudent(Model model, @RequestParam("search") String name) {
		List<Student> st = studentdao.findStudentByName("%"+name+"%");
		if (st.size()>0) {
			model.addAttribute("st", st);
			return "/searchStudent";
		}else {
			model.addAttribute("mess", "ID Student not exist !!");
			List<Student> ls = studentdao.findAll();
			model.addAttribute("liststu", ls);
			return "/StudentScreen";
		}
	}
	
	@RequestMapping("/filterClass")
	public String filterclass(Model model, @RequestParam("classs")String classs) {
		List<Student> st = studentdao.filterClass(classs);
		model.addAttribute("liststu", st);
		return "/StudentScreen";
	}
}
