package hu.webuni.hr.javaKing.service;

import hu.webuni.hr.javaKing.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService {

    @Override
    public int getPayRaisePercent(Employee employee) {

        return 5;
    }
}
