package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.domain.Seller;
import com.rev.cat.catservice.dto.SellerRequestDTO;
import com.rev.cat.catservice.repository.CustomerRepository;
import com.rev.cat.catservice.repository.ProductRepository;
import com.rev.cat.catservice.repository.SellerRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService extends GenericService<Seller, SellerRequestDTO> {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller findById(String id) {
        return sellerRepository.findOne(id);
    }

    @Override
    public Seller delete(String id) {
        Seller seller = sellerRepository.findOne(id);

        sellerRepository.delete(seller);

        return seller;
    }

    @Override
    public Seller insert(SellerRequestDTO dto) {
        Seller seller = buildCreateSeller(dto);

        sellerRepository.insert(seller);

        return seller;
    }

    @Override
    public Seller update(String id, SellerRequestDTO dto) {
        Seller seller = findById(id);

        buildUpdateSeller(seller, dto);
        sellerRepository.save(seller);

        return seller;
    }

    private Seller buildCreateSeller(SellerRequestDTO dto) {
        Seller seller = new Seller();

        seller.setQuantity(dto.getQuantity());
        seller.setDescription(dto.getDescription());
        seller.setCustomer(customerRepository.findOne(dto.getCustomerId()));

        Product product = productRepository.findOne(dto.getProductId());
        product.setStock(product.getStock() - dto.getQuantity());
        seller.setTotalSell(product.getPrice() * dto.getQuantity());
        product = productRepository.save(product);
        seller.setProduct(product);

        return seller;
    }

    private void buildUpdateSeller(Seller seller, SellerRequestDTO dto) {
        seller.setDescription(dto.getDescription());
        seller.setQuantity(dto.getQuantity());
        seller.setCustomer(customerRepository.findOne(dto.getCustomerId()));

        Product product = productRepository.findOne(dto.getProductId());
        seller.setTotalSell(product.getPrice() * dto.getQuantity());
        product.setStock(product.getStock() - dto.getQuantity());
        product = productRepository.save(product);
        seller.setProduct(product);
    }
}
