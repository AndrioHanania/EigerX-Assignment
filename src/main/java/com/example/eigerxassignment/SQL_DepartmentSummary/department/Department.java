package com.example.eigerxassignment.SQL_DepartmentSummary.department;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Department")
@Table(name = "departments")
public class Department
{
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence")
    @Column(
            name = "id",
            updatable = false)
    private Integer id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "location",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String location;
}
