package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Quotation;
import com.rev.cat.catservice.dto.QuotationRequestDTO;
import com.rev.cat.catservice.repository.QuotationRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService extends GenericService<Quotation, QuotationRequestDTO> {

    @Autowired
    private QuotationRepository quotationRepository;

    @Override
    public List<Quotation> findAll() {
        return quotationRepository.findAll();
    }

    @Override
    public Quotation findById(String id) {
        return quotationRepository.findOne(id);
    }

    @Override
    public Quotation delete(String id) {
        Quotation position = findById(id);
        quotationRepository.delete(position);

        return position;
    }

    @Override
    public Quotation insert(QuotationRequestDTO dto) {
        Quotation quotation = buildCreateQuotation(dto);
        quotation = quotationRepository.insert(quotation);

        return quotation;
    }

    @Override
    public Quotation update(String id, QuotationRequestDTO dto) {
        Quotation quotation = findById(id);
        buildUpdateQuotation(quotation, dto);

        quotationRepository.save(quotation);
        return quotation;
    }

    private Quotation buildCreateQuotation(QuotationRequestDTO dto) {
        Quotation quotation = new Quotation();
        quotation.setEmail(dto.getEmail());
        quotation.setName(dto.getName());
        quotation.setProductName(dto.getProductName());
        quotation.setMessage(dto.getMessage());

        return quotation;
    }

    private void buildUpdateQuotation(Quotation quotation, QuotationRequestDTO dto) {
        quotation.setEmail(dto.getEmail());
        quotation.setName(dto.getName());
        quotation.setProductName(dto.getProductName());
        quotation.setMessage(dto.getMessage());
    }
}
