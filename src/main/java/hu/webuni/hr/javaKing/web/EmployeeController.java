package hu.webuni.hr.javaKing.web;

import hu.webuni.hr.javaKing.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private Map<Long, EmployeeDTO> employees = new HashMap<>();

    {
        employees.put(1L, new EmployeeDTO(1, "Balazs", "Developer", 100, LocalDateTime.of(2021, Month.MAY, 17, 9,00)));
        employees.put(2L, new EmployeeDTO(2, "Kata", "TestAutomationEngineer", 80, LocalDateTime.of(2022, Month.JUNE, 17, 9,00)));
    }


    @GetMapping
    public List<EmployeeDTO> getAll() {
        return new ArrayList<>(employees.values());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable long id) {
        EmployeeDTO employeeDTO = employees.get(id);
        if (employeeDTO != null) {
            return ResponseEntity.ok(employeeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employees.put(employeeDTO.getId(), employeeDTO);
        return employeeDTO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> modifyEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {
        if (!employees.containsKey(id)) {
            return ResponseEntity.notFound().build();
        } else {
            employeeDTO.setId(id);
            employees.put(id, employeeDTO);
            return ResponseEntity.ok(employeeDTO);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employees.remove(id);
    }

    @GetMapping(params = "minSalary")
    public List<EmployeeDTO> getAboveThisSalary(@RequestParam(required = false) int minSalary) {
        return employees.values().stream()
                .filter(e -> e.getSalary() > minSalary)
                .collect(Collectors.toList());
    }
}
