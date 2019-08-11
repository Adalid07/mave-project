package com.rev.cat.catservice.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.dto.ProductRequestDTO;
import com.rev.cat.catservice.repository.BrandRepository;
import com.rev.cat.catservice.repository.CatalogRepository;
import com.rev.cat.catservice.repository.ProductRepository;
import com.rev.cat.catservice.repository.file.DBFileRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import com.rev.cat.catservice.service.utils.ImageUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ProductService extends GenericService<Product, ProductRequestDTO> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private DBFileRepository dbFileRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);
        return product;
    }

    @Override
    public Product insert(ProductRequestDTO dto) {
        Product product = buildCreateSafetyEquipment(dto);
        product = productRepository.insert(product);
        return product;
    }

    @Override
    public Product update(String id, ProductRequestDTO dto) {
        Product product = findById(id);
        buildUpdateSafetyEquipment(product, dto);
        productRepository.save(product);
        return product;
    }

    private Product buildCreateSafetyEquipment(ProductRequestDTO dto) {
        Product product = new Product();

        setProductInformation(product, dto);

        return product;
    }

    private void buildUpdateSafetyEquipment(Product product, ProductRequestDTO dto) {

        setProductInformation(product, dto);
    }

    private void setProductInformation(Product product, ProductRequestDTO dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCatalog(catalogRepository.findOne(dto.getCatalogId()));
        product.setBrand(brandRepository.findOne(dto.getBrandId()));
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
    }
}
