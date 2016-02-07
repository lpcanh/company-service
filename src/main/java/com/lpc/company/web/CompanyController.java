package com.lpc.company.web;

import com.lpc.company.model.Company;
import com.lpc.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public Set<Company> getAll(){
        return companyService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> create(@Valid @RequestBody CompanyForm form){
        return new ResponseEntity<>(companyService.create(form).getId(), HttpStatus.CREATED);
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Integer> update(@RequestParam Integer id, @Valid @RequestBody CompanyForm form){
        return companyService.update(id, form)
                .map(cpm -> new ResponseEntity<>(cpm.getId(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompanyForm> get(@RequestParam Integer id){
        return companyService.get(id)
                .map(cpm -> new ResponseEntity<>(cpm.toForm(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer id){
        companyService.delete(id);
    }
}
