package com.lpc.company.web;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

@Data
public class CompanyForm {
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;
    @Email
    private String email;
    private String phone;
    private Set<EmployeeForm> employees;
}
