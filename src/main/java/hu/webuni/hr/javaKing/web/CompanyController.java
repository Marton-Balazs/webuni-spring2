package hu.webuni.hr.javaKing.web;


import hu.webuni.hr.javaKing.dto.CompanyDTO;
import hu.webuni.hr.javaKing.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private Map<Long, CompanyDTO> companies = new HashMap<>();
    private List<EmployeeDTO> employees = new ArrayList<>();
    {
        employees.add(new EmployeeDTO(1, "Joe", "developer", 100, LocalDateTime.of(2022, Month.MARCH, 10, 9, 00)));
        employees.add(new EmployeeDTO(2, "Jane", "tester", 500, LocalDateTime.of(2015, Month.MARCH, 15, 10, 00)));
    }

    {
        companies.put(1L, new CompanyDTO(1L, 1,"Accenture", "1118 Bp Szep u 18", employees));
        companies.put(2L, new CompanyDTO(2L, 1,"T-systems", "1117 Bp Ronda u 20", employees));
    }

    @GetMapping
    public List<CompanyDTO> getAll(@RequestParam(required = false) Boolean full) {
        if (full == null || !full) {
            return companies.values().stream()
                    .map(c -> new CompanyDTO(c.getId(), c.getRegistrationNumber(), c.getName(), c.getAddress(), Collections.emptyList()))
                    .toList();
        }
        else {
            return new ArrayList<>(companies.values());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyDTO> getById(@PathVariable long id, @RequestParam(required = false) Boolean full) {
        CompanyDTO companyDTO = companies.get(id);
        if (!companies.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        if (full == null || !full) {
            return ResponseEntity.ok(new CompanyDTO(companyDTO.getId(), companyDTO.getRegistrationNumber(), companyDTO.getName(), companyDTO.getAddress(), Collections.emptyList()));
        }
        return ResponseEntity.ok(companyDTO);
    }

    @PostMapping
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO) {
        companies.put(companyDTO.getId(), companyDTO);
        return companyDTO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> modifyCompany(@PathVariable long id, @RequestBody CompanyDTO companyDTO) {
        if (!companies.containsKey(id)) {
            return ResponseEntity.notFound().build();
        } else {
            companyDTO.setId(id);
            companies.put(id, companyDTO);
            return ResponseEntity.ok(companyDTO);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable long id) {
        companies.remove(id);
    }

    @PostMapping("/{id}/newEmployee")
    public ResponseEntity<CompanyDTO> newEmployeeForCompany(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO){
        if (!companies.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        CompanyDTO companyDTO = companies.get(id);
        companyDTO.getEmployees().add(employeeDTO);
        return ResponseEntity.ok(companyDTO);
    }

    @DeleteMapping("/{companyId}/deleteEmployee/{employeeId}")
    public ResponseEntity<CompanyDTO> deleteEmployeeFromCompany(@PathVariable long companyId, @PathVariable long employeeId) {
        if (!companies.containsKey(companyId)) {
            return ResponseEntity.notFound().build();
        }
        CompanyDTO companyDTO = companies.get(companyId);
        companyDTO.getEmployees().removeIf(e -> e.getId() == employeeId);
        return ResponseEntity.ok(companyDTO);
    }

    @PostMapping("/{id}/change")
    public CompanyDTO changeEmployeeList(@RequestBody List<EmployeeDTO> employees, @PathVariable long id){
        companies.get(id).setEmployees(employees);
        return companies.get(id);
    }

}
