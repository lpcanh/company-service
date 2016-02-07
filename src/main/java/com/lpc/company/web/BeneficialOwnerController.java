package com.lpc.company.web;

import com.lpc.company.model.BeneficialOwner;
import com.lpc.company.service.BeneficialOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company/{companyId}/beneficial-owner")
public class BeneficialOwnerController {
    @Autowired
    BeneficialOwnerService beneficialOwnerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BeneficialOwner> create(@PathVariable Integer companyId) {
        return beneficialOwnerService.getAll(companyId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> create(@PathVariable Integer companyId, @Valid @RequestBody BeneficialOwnerForm form) {
        return new ResponseEntity<>(beneficialOwnerService.create(companyId, form).getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BeneficialOwnerForm> get(@PathVariable Integer companyId, @RequestParam Integer id) {
        return beneficialOwnerService.get(companyId, id)
                .map(BeneficialOwner::toForm).map(form -> new ResponseEntity<>(form, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Integer> update(@PathVariable Integer companyId,
                                       @PathVariable Integer id,
                                       @Valid @RequestBody BeneficialOwnerForm form) {
        return beneficialOwnerService.update(companyId, id, form)
                .map(bO -> new ResponseEntity<>(bO.getId(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer companyId,
                                       @PathVariable Integer id) {
        beneficialOwnerService.delete(companyId, id);
    }
}
