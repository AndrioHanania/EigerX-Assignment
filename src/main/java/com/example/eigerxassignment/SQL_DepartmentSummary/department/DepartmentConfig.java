package com.example.eigerxassignment.SQL_DepartmentSummary.department;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DepartmentConfig {
    @Bean
    CommandLineRunner departmentCommandLineRunner
            (DepartmentService departmentService)
    {
        return args -> {
            departmentService.saveAll(List.of(
                    new Department(1, "Executive", "Sydney"),
                    new Department(2, "Production", "Sydney"),
                    new Department(3, "Resources", "Cape Town"),
                    new Department(4, "Technical", "Texas"),
                    new Department(5, "Management", "Paris")
            ));
        };
    }
}