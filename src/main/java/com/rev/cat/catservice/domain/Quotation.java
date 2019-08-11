package com.rev.cat.catservice.domain;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Quotation extends GenericDomain {

    private String email;
    private String name;
    private String productName;
    private String message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
