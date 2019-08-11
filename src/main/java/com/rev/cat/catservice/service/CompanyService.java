package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Company;
import com.rev.cat.catservice.dto.CompanyRequestDTO;
import com.rev.cat.catservice.repository.CompanyRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService extends GenericService<Company, CompanyRequestDTO> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(String id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company delete(String id) {
        Company company = findById(id);
        companyRepository.delete(company);
        return company;
    }

    @Override
    public Company insert(CompanyRequestDTO dto) {
        Company company = buildCreateCompany(dto);
        company = companyRepository.insert(company);
        return company;
    }

    @Override
    public Company update(String id, CompanyRequestDTO dto) {
        Company company = findById(id);
        buildUpdateCompany(company, dto);
        company = companyRepository.save(company);
        return company;
    }

    private Company buildCreateCompany(CompanyRequestDTO dto) {
        Company company = new Company();
        setCompanyInformation(dto, company);

        return company;
    }

    private void buildUpdateCompany(Company company, CompanyRequestDTO dto) {
        setCompanyInformation(dto, company);
    }

    private static void setCompanyInformation(CompanyRequestDTO dto, Company company) {
        company.setName(dto.getName());
        company.setAddress(dto.getAddress());
        company.setEmail(dto.getEmail());
        company.setMission(dto.getMission());
        company.setVision(dto.getVision());
        company.setPhone(dto.getPhone());
    }
}
