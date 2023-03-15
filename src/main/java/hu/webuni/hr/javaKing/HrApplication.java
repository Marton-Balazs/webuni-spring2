package hu.webuni.hr.javaKing;

import hu.webuni.hr.javaKing.model.Employee;
import hu.webuni.hr.javaKing.service.DefaultEmployeeService;
import hu.webuni.hr.javaKing.service.EmployeeService;
import hu.webuni.hr.javaKing.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

    @Autowired
    SalaryService salaryService;

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee(1, "Balazs", "developer", 100, LocalDateTime.of(2015, Month.MARCH, 10, 9, 00));
        System.out.println(salaryService.getNewSalary(e1));
    }

}
