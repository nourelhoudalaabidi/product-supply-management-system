package com.example.tutoAPI.product.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "factories")
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "factory")
    private List<Product> products;

    public Factory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
