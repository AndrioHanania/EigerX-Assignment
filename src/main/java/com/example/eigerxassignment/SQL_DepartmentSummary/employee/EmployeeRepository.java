package com.example.eigerxassignment.SQL_DepartmentSummary.employee;

import com.example.eigerxassignment.SQL_DepartmentSummary.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer>
{
    @Query("SELECT COUNT(e) " +
            "FROM Employee e " +
            "WHERE e.departmentId = :departmentId")
    Integer countByDepartmentId(@Param("departmentId") Integer departmentId);
}