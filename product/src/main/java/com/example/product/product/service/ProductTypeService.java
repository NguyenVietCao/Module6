package com.example.product.product.service;

import com.example.product.product.model.ProductType;
import com.example.product.product.repository.IProductRepository;
import com.example.product.product.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductTypeService implements IProductTypeService{
    @Autowired
    private IProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> getListProductType() {
        return productTypeRepository.findAll();
    }
}
