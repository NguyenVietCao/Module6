package com.example.product.product.service;

import com.example.product.product.model.Product;
import com.example.product.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
   private IProductRepository productRepository;
    @Override
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean deleteProduct(int id) {
productRepository.deleteById(id);
        return true;
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }
}
