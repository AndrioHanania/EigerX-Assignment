package com.example.eigerxassignment.SQL_DepartmentSummary.department;

import com.example.eigerxassignment.SQL_DepartmentSummary.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @Getter
    @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    private class DepartmentWithEmp{
        private String name;
        private Integer employeesInDept;
    }


    @Test
    public void myTest(){
        List<DepartmentWithEmp> departmentWithEmpArray = getDepartmentBySpecialOrder();
        assertEquals(departmentWithEmpArray, List.of(
                new DepartmentWithEmp("Executive", 2),
                new DepartmentWithEmp("Technical", 2),
                new DepartmentWithEmp("Production", 1),
                new DepartmentWithEmp("Management", 0),
                new DepartmentWithEmp("Resources", 0)
        ));
    }

    /**
     * This is the requested method
     * The test above us
     * */
    private List<DepartmentWithEmp> getDepartmentBySpecialOrder() {
        return departmentRepository.findAll().stream()
                .map(department ->
                {
                    Integer employeesInDept = employeeRepository.countByDepartmentId(department.getId());
                    return new DepartmentWithEmp(department.getName(), employeesInDept);
                })
                .sorted(Comparator.comparing(DepartmentWithEmp::getEmployeesInDept).reversed()
                        .thenComparing(DepartmentWithEmp::getName))
                .collect(Collectors.toList());
    }
}