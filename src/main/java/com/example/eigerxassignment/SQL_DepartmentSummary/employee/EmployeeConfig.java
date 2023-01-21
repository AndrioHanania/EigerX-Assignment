package com.example.eigerxassignment.SQL_DepartmentSummary.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    @DependsOn("departmentCommandLineRunner")
    CommandLineRunner employeeCommandLineRunner
            (EmployeeService employeeService)
    {
        return args -> {
            employeeService.saveAll(List.of(
                    new Employee(1, "Candice", 4685, 1),
                    new Employee(2, "Julia", 2559, 2),
                    new Employee(3, "Bob", 4405, 4),
                    new Employee(4, "Scarlet", 2350, 1),
                    new Employee(5, "Ileana", 1151, 4)
            ));
        };
    }
}