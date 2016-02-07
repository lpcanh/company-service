package com.lpc.company.web;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class BeneficialOwnerForm {
    @NotEmpty
    private String name;
}
