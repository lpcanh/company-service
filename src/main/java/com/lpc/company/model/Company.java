package com.lpc.company.model;

import com.lpc.company.web.CompanyForm;
import com.lpc.company.web.EmployeeForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();


    public void setEmployees(Set<EmployeeForm> employeeForms) {
        employees.clear();
        if (employeeForms != null && !employeeForms.isEmpty()) {
            for(EmployeeForm eF: employeeForms) {
                Employee ee = new Employee();
                ee.setName(eF.getName());
                ee.setCompany(this);
                employees.add(ee);
            }
        }
    }

    public CompanyForm toForm() {
        CompanyForm form = new CompanyForm();
        form.setName(name);
        form.setAddress(address);
        form.setCity(city);
        form.setCountry(country);
        form.setPhone(phone);
        form.setEmail(email);
        if (employees != null && !employees.isEmpty()) {
            form.setEmployees(employees.stream().map(Employee::toForm).collect(Collectors.toSet()));
        }

        return form;
    }
}
