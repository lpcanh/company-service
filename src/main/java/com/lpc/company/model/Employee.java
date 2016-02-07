package com.lpc.company.model;

import com.lpc.company.web.EmployeeForm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "employee")
public class Employee extends Person{
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    public EmployeeForm toForm() {
        EmployeeForm form = new EmployeeForm();
        form.setName(name);
        return form;
    }
}
