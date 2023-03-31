package hu.webuni.hr.javaKing.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {

    private Long id;
    private int registrationNumber;
    private String name;
    private String address;
    private List<EmployeeDTO> employees;

    public CompanyDTO() {
    }

    public CompanyDTO(Long id, int registrationNumber, String name, String address, List<EmployeeDTO> employees) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.address = address;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
