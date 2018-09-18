package com.krotos;

import com.krotos.service.EmployeeService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {

    private static final Logger log=Logger.getLogger(EmployeeController.class);

    public EmployeeController(){
        System.out.println("EmployeeController()");
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model){
        List<Employee> employeeList=employeeService.getAllEmployees();
        model.addObject("employeeList",employeeList);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model){
        Employee employee=new Employee();
        model.addObject("employee",employee);
        model.setViewName("EmployeeForm");
        return model;
    }

    @RequestMapping(value = "saveEmployee",method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee){
        if(employee.getId()==0){
            employeeService.addEmployee(employee);
        }else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request){
        int employeeId=Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "editEmployee",method = RequestMethod.GET)
    public ModelAndView editContract(HttpServletRequest request){
        int employeeId=Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployee(employeeId);
        ModelAndView model=new ModelAndView("EmployeeForm");
        model.addObject("employee",employee);
        return model;
    }

}
