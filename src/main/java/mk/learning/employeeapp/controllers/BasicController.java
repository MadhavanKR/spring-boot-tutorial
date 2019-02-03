package mk.learning.employeeapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mk.learning.employeeapp.model.AddEmployeeModel;
import mk.learning.employeeapp.services.DatabaseService;

@Controller
public class BasicController {

	/*
	 * @Controller is used for MVC (with views).
	 * 
	 * @RestController is used for rest api development (does not support views. i.e
	 * html or jsp) all the htmls, css and js can be kept under
	 * src/main/resources/static and they can be referred using relative path to
	 * static folder
	 */

	@Autowired
	DatabaseService dbService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloworld(ModelMap model, HttpServletRequest request) {
		return "tmp/hello.html"; // whatever string you return, spring by default searches for a view by that
									// name
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmpGetHandler() {
		return "tmp/hello.html";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmpPostHandler(@ModelAttribute AddEmployeeModel emp) {
		if (dbService.addEmployeeToDB(emp.getEmpName(), emp.getEmpEmail()))
			return "redirect:/addEmployee?empAdded=true";
		else
			return "redirect:/addEmployee?empAdded=false";
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmpGetHandler() {
		return "tmp/deleteEmp.html";
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmpPostHandler(@ModelAttribute AddEmployeeModel emp) {
		if (dbService.deleteEmployeeFromDB(emp.getEmpName()))
			return "redirect:/deleteEmployee?empdeleted=true";
		else
			return "redirect:/deleteEmployee?empDeleted=false";
	}

	//you use modelmap when you want to pass some information back to the view
	//in the below controller, you want to pass list of employee names back to the view.
	//whatever you want to pass, add it as an attribute to model object
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public String getEmployeeGetHandler(ModelMap model) {
		List<String> empNames = dbService.getEmployeeNames();
		if (empNames == null)
			return "tmp/failure.html";
		else {
			model.addAttribute("employees", empNames);
			return "/WEB-INF/jsp/listEmployees.jsp";
		}
	}
}
