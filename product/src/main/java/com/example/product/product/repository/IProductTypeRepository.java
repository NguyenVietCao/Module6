package com.example.product.product.repository;

import com.example.product.product.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType,Integer> {
}
