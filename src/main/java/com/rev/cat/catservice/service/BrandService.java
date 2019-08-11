package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Brand;
import com.rev.cat.catservice.dto.BrandRequestDTO;
import com.rev.cat.catservice.repository.BrandRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService extends GenericService<Brand, BrandRequestDTO> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(String id) {
        return brandRepository.findOne(id);
    }

    @Override
    public Brand delete(String id) {
        Brand brand = findById(id);
        brandRepository.delete(brand);
        return brand;
    }

    @Override
    public Brand insert(BrandRequestDTO dto) {
        Brand brand = buildCreateBrand(dto);
        brand = brandRepository.insert(brand);
        return brand;
    }

    @Override
    public Brand update(String id, BrandRequestDTO dto) {
        Brand brand = findById(id);
        buildUpdateBrand(brand, dto);
        brand = brandRepository.save(brand);
        return brand;
    }

    private Brand buildCreateBrand(BrandRequestDTO dto) {
        Brand brand = new Brand();
        setBrandInformation(dto, brand);

        return brand;
    }

    private void buildUpdateBrand(Brand brand, BrandRequestDTO dto) {
        setBrandInformation(dto, brand);
    }

    private void setBrandInformation(BrandRequestDTO dto, Brand brand) {
        brand.setName(dto.getName());
        brand.setCode(dto.getCode());
        brand.setDescription(dto.getDescription());
    }
}
