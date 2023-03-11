package hu.webuni.hr.javaKing.config;

import hu.webuni.hr.javaKing.service.DefaultEmployeeService;
import hu.webuni.hr.javaKing.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeeService() {
        return new DefaultEmployeeService();
    }

}
