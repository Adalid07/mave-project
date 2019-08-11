package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Catalog;
import com.rev.cat.catservice.dto.CatalogRequestDTO;
import com.rev.cat.catservice.service.CatalogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/catalogs")
@Api(value = "catalogs", description = "Operations related to catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Catalog> findAll() {
        return catalogService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Catalog findById(@PathVariable String id) {
        return catalogService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Catalog insert(@RequestBody CatalogRequestDTO dto) {
        return catalogService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Catalog delete(@PathVariable String id) {
        return catalogService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Catalog update(@PathVariable String id, @RequestBody CatalogRequestDTO dto) {
        return catalogService.update(id, dto);
    }
}
