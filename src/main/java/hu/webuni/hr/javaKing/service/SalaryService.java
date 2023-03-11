package hu.webuni.hr.javaKing.service;

import hu.webuni.hr.javaKing.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService{

    @Autowired
    private EmployeeService employeeService;

    public int getNewSalary(Employee employee) {
        return (int)(employee.getSalary() / 100.0 * (100 + employeeService.getPayRaisePercent(employee)));

    }
}
