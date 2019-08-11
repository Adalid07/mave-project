package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Brand;
import com.rev.cat.catservice.dto.BrandRequestDTO;
import com.rev.cat.catservice.service.BrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/brands")
@Api(value = "brands", description = "Operations related to brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Brand findById(@PathVariable String id) {
        return brandService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Brand insert(@RequestBody BrandRequestDTO dto) {
        return brandService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Brand delete(@PathVariable String id) {
        return brandService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Brand update(@PathVariable String id, @RequestBody BrandRequestDTO dto) {
        return brandService.update(id, dto);
    }
}
