package com.rev.cat.catservice.dto;

import com.rev.cat.catservice.domain.Customer;
import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.domain.enums.IncidentSeverity;
import com.rev.cat.catservice.domain.enums.IncidentType;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

public class BuyerRequestDTO {

    private String description;
    private Date date;
    private double taxes;
    private double customsTaxes;
    private double importTaxes;
    private double totalCost;
    private double price;
    private Integer stock;

    private String productId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getCustomsTaxes() {
        return customsTaxes;
    }

    public void setCustomsTaxes(double customsTaxes) {
        this.customsTaxes = customsTaxes;
    }

    public double getImportTaxes() {
        return importTaxes;
    }

    public void setImportTaxes(double importTaxes) {
        this.importTaxes = importTaxes;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
