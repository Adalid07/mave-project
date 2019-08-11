package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Seller;
import com.rev.cat.catservice.dto.SellerRequestDTO;
import com.rev.cat.catservice.service.SellerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@Api(value = "sellers", description = "Operations related to sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> findAll() {
        return sellerService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Seller findById(@PathVariable String id) {
        return sellerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Seller insert(@RequestBody SellerRequestDTO dto) {
        return sellerService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Seller delete(@PathVariable String id) {
        return sellerService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Seller update(@PathVariable String id, @RequestBody SellerRequestDTO dto) {
        return sellerService.update(id, dto);
    }
}

