package com.example.product.product.service;

import com.example.product.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> getListProduct();
    Page<Product> getPage(Pageable pageable);

    void deleteById(Integer id);
    boolean deleteProduct(int id);
    void addNewProduct(Product product);
}
