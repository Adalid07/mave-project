package com.rev.cat.catservice.domain;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/*
* @autor rveizaga
*/

@Document
public class Buyer extends GenericDomain {

    private String description;
    private Date date;
    private double taxes;
    private double customsTaxes;
    private double importTaxes;
    private double totalCost;

    @DBRef
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
