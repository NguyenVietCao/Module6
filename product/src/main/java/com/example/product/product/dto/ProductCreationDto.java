package com.example.product.product.dto;

import com.example.product.product.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductCreationDto implements Validator {
    private int id;
    private String productCode;
    private String productName;
    private String inputDay;
    private String quantity;
    private ProductType productType;

    public ProductCreationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInputDay() {
        return inputDay;
    }

    public void setInputDay(String inputDay) {
        this.inputDay = inputDay;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
ProductCreationDto productCreationDto = (ProductCreationDto) target;
        if (!productCreationDto.getProductName().matches("^([\\w\\s]){1,800}$")) {
            errors.rejectValue("productName", "productName", "khong phai ten san pham");
        }
        if (!productCreationDto.getProductCode().matches("^([\\w\\s]){1,300}$")) {
            errors.rejectValue("productCode", "productCode", "khong phai ma san pham");
        }
    }
}
