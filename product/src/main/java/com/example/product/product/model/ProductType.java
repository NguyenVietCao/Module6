package com.example.product.product.model;

import javax.persistence.*;

@Entity
@Table(name = "productType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public ProductType() {

    }

    public ProductType(String name) {
        this.name = name;
    }

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
