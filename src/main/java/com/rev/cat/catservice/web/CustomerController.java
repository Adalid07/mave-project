package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Customer;
import com.rev.cat.catservice.dto.CustomerRequestDTO;
import com.rev.cat.catservice.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
@Api(value = "customers", description = "Operations related to customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Customer findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer insert(@RequestBody CustomerRequestDTO dto) {
        return customerService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Customer delete(@PathVariable String id) {
        return customerService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Customer update(@PathVariable String id, @RequestBody CustomerRequestDTO dto) {
        return customerService.update(id, dto);
    }
}
