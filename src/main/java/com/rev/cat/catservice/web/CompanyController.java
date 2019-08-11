package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Company;
import com.rev.cat.catservice.dto.CompanyRequestDTO;
import com.rev.cat.catservice.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
@Api(value = "companies", description = "Operations related to companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Company findById(@PathVariable String id) {
        return companyService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Company insert(@RequestBody CompanyRequestDTO dto) {
        return companyService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Company delete(@PathVariable String id) {
        return companyService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Company update(@PathVariable String id, @RequestBody CompanyRequestDTO dto) {
        return companyService.update(id, dto);
    }
}
