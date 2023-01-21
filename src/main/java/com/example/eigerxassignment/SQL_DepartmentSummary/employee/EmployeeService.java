package com.example.eigerxassignment.SQL_DepartmentSummary.employee;

import com.example.eigerxassignment.SQL_DepartmentSummary.department.DepartmentRepository;
import com.example.eigerxassignment.SQL_DepartmentSummary.exceptions.DepartmentNotFoundException;
import com.example.eigerxassignment.SQL_DepartmentSummary.department.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    public void save(Employee employee)
    {
        Integer deptId = employee.getDepartmentId();
        if (!departmentService.existsById(deptId))
            throw new DepartmentNotFoundException
                    (String.format("Department with id: %s  not found", deptId));
        employeeRepository.save(employee);
    }

    public void saveAll(List<Employee> employees) {
        employees.forEach(this::save);
    }

    public Integer countByDepartmentId(Integer id) {
        return employeeRepository.countByDepartmentId(id);
    }
}