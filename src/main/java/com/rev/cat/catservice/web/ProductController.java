package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.dto.ProductRequestDTO;
import com.rev.cat.catservice.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* @autor rveizaga
*/

@RestController
@RequestMapping("/products")
@Api(value = "products", description = "Operations related to Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product insert(@RequestBody ProductRequestDTO dto) {
        return productService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Product delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Product update(@PathVariable String id, @RequestBody ProductRequestDTO dto) {
        return productService.update(id, dto);
    }
}
