package com.lpc.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lpc.company.web.EmployeeForm;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "companyId")
    @JsonIgnore
    private Company company;

    public EmployeeForm toForm() {
        EmployeeForm form = new EmployeeForm();
        form.setName(name);
        return form;
    }
}
