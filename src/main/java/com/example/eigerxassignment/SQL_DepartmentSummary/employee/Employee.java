package com.example.eigerxassignment.SQL_DepartmentSummary.employee;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Employee") //for Hibernate
@Table(name = "employees")//for table in db
public class Employee
{
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1)
    @GeneratedValue(//generate value for id for every new student
            strategy = GenerationType.SEQUENCE,//1,2,3,...
            generator = "employee_sequence")
    @Column(
            name = "id",
            updatable = false)
    private Integer id;
    @Column(
            name = "name",            // name in the db
            nullable = false,         //cant be null
            columnDefinition = "TEXT" //type in db
    )
    private String name;
    @Column(
            name = "salary",
            nullable = false
    )
    private Integer salary;
    @JoinColumn(nullable = false, name = "department_id")
    private Integer departmentId;
}