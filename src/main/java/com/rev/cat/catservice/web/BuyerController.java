package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Buyer;
import com.rev.cat.catservice.dto.BuyerRequestDTO;
import com.rev.cat.catservice.service.BuyerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
@Api(value = "buyers", description = "Operations related to buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> findAll() {
        return buyerService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Buyer findById(@PathVariable String id) {
        return buyerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Buyer insert(@RequestBody BuyerRequestDTO dto) {
        return buyerService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Buyer delete(@PathVariable String id) {
        return buyerService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Buyer update(@PathVariable String id, @RequestBody BuyerRequestDTO dto) {
        return buyerService.update(id, dto);
    }
}
