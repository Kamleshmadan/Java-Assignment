package com.emp.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.emp.login.model.Employee;
import com.emp.login.repository.EmpRepository;
import com.emp.login.service.EmpService;

@Controller
public class UpController {
	@Autowired
	private EmpRepository eRepo;
	private EmpService empService;

	public UpController(EmpService empService) {
		super();
		this.empService = empService;
	}
//	@GetMapping("/")
//	public ModelAndView getAllEmployees1()
//	{
//		ModelAndView mav = new ModelAndView("employee");
//		mav.addObject("employees",eRepo.findAll());
//		return mav;
//	
//	}

	@GetMapping("/employee")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("employees", eRepo.findAll());
		return mav;

	}

	@GetMapping("/employee/update/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("employee", empService.getEmployeeById(id));
		return "up";
	}

	@PostMapping("/employee/save/edit/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmp = empService.getEmployeeById(id);
		existingEmp.setId(id);
		existingEmp.setName(employee.getName());
		existingEmp.setDepartment(employee.getDepartment());
		existingEmp.setTitle(employee.getTitle());
		existingEmp.setMob(employee.getMob());
		empService.updateEmployee(existingEmp);
		return "redirect:/employee";
	}

	@GetMapping("/employee/delete/{id}")
	public String deleteEmp(@PathVariable Long id) {
		empService.deleteEmpById(id);
		return "redirect:/employee";
	}

}
