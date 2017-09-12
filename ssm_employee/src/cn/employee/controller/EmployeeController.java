package cn.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.employee.model.Employee;
import cn.employee.service.EmployeeService;



@Controller
public class EmployeeController {
    @Autowired
	private EmployeeService employeeService;
    
    @RequestMapping(value="/login",method=(RequestMethod.POST))
    public String login(HttpSession session,HttpServletRequest request, Employee employee){

    	Employee employee1= employeeService.login(employee);
    	if(employee1!=null){
    	String ename=employee1.getEname();
    	System.out.println(ename);
    	session.setAttribute("ename", ename);
		return "redirect:frame.jsp";
    	}
    	return "redirect:index.jsp";
    	
    }    
    @RequestMapping("/frame/listEmp")
    public String listEmp(Model model){
    	List<Employee> list=employeeService.findAll();
    	System.out.println(list);
    	model.addAttribute("list", list);
		return "forward:listEmployee.jsp";
    	
    }
    
    
    private String username;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@RequestMapping("/ajaxtext")@ResponseBody
    public String ajaxtext(String username){

    		int i=employeeService.findByUsername(username);
			System.out.println(i);
			System.out.println(username);
    		if(i!=0){

    			return "success";
    		}
    		else{

		return "error";}
    	
    	
    }
	
}
