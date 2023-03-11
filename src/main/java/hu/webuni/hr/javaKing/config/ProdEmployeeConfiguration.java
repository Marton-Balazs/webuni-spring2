package hu.webuni.hr.javaKing.config;

import hu.webuni.hr.javaKing.service.EmployeeService;
import hu.webuni.hr.javaKing.service.SmartEmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdEmployeeConfiguration {

    @Bean
    public EmployeeService employeeService() {

        return new SmartEmployeeService();
    }

}
