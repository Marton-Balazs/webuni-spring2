package hu.webuni.hr.javaKing.web;

import hu.webuni.hr.javaKing.model.Employee;
import hu.webuni.hr.javaKing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/payRaisePercent")
    public int getPayRaisePercent(@RequestBody Employee employee) {
        return employeeService.getPayRaisePercent(employee);
    }
}
