package com.example.eigerxassignment.SQL_DepartmentSummary.department;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public boolean existsById(Integer departmentId) {
        return departmentRepository.existsById(departmentId);
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

    public void saveAll(List<Department> departments) {
        departmentRepository.saveAll(departments);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}