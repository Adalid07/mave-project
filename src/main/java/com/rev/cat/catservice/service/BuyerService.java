package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Buyer;
import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.dto.BuyerRequestDTO;
import com.rev.cat.catservice.repository.BuyerRepository;
import com.rev.cat.catservice.repository.ProductRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuyerService extends GenericService<Buyer, BuyerRequestDTO> {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findById(String id) {
        return buyerRepository.findOne(id);
    }

    @Override
    public Buyer delete(String id) {
        Buyer buyer = findById(id);
        buyerRepository.delete(buyer);
        return buyer;
    }

    @Override
    public Buyer insert(BuyerRequestDTO dto) {
        Buyer buyer = buildCreateBuyer(dto);
        buyer = buyerRepository.insert(buyer);
        return buyer;
    }

    @Override
    public Buyer update(String id, BuyerRequestDTO dto) {
        Buyer buyer = findById(id);
        buildUpdateBuyer(buyer, dto);
        buyer = buyerRepository.save(buyer);
        return buyer;
    }

    private Buyer buildCreateBuyer(BuyerRequestDTO dto) {
        Buyer buyer = new Buyer();
        setBuyerInformation(dto, buyer);

        return buyer;
    }

    private void buildUpdateBuyer(Buyer buyer, BuyerRequestDTO dto) {
        setBuyerInformation(dto, buyer);
    }

    private void setBuyerInformation(BuyerRequestDTO dto, Buyer buyer) {
        buyer.setDate(dto.getDate());
        buyer.setDescription(dto.getDescription());
        buyer.setCustomsTaxes(dto.getCustomsTaxes());
        buyer.setTaxes(dto.getTaxes());
        buyer.setImportTaxes(dto.getImportTaxes());
        buyer.setTotalCost((dto.getStock() * dto.getPrice()) + dto.getTaxes() + dto.getCustomsTaxes() + dto.getImportTaxes());

        Product product = productRepository.findOne(dto.getProductId());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        productRepository.save(product);

        buyer.setProduct(product);
    }
}
