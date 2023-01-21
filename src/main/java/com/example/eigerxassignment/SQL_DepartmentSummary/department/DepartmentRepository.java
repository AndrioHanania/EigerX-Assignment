package com.example.eigerxassignment.SQL_DepartmentSummary.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository
        extends JpaRepository<Department, Integer>
{
    boolean existsById(Integer id);
}