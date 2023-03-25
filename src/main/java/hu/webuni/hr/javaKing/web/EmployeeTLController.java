package hu.webuni.hr.javaKing.web;

import hu.webuni.hr.javaKing.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeTLController {

    private List<Employee> allEmployees = new ArrayList<>();

    {
        allEmployees.add(new Employee(1, "Balazs", "Developer", 100, LocalDateTime.of(2021, Month.MAY, 17, 9,00)));
        allEmployees.add(new Employee(2, "Kata", "TestAutomationEngineer", 80, LocalDateTime.of(2022, Month.JANUARY, 10, 9,00)));
        allEmployees.add(new Employee(3, "Poppy", "NewBorn", 1, LocalDateTime.of(2022, Month.OCTOBER, 15, 21,15)));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Employees");
        return "index";
    }

    @GetMapping("/employees")
    public String listEmployees(Map<String, Object> model) {
        model.put("employees", allEmployees);
        model.put("newEmployee", new Employee());
        return "employees";
    }


    @PostMapping("/employees")
    public String addEmployee(Employee employee) {
        allEmployees.add(employee);
        return "redirect:employees";
    }

}
