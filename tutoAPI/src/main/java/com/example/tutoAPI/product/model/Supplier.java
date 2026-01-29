package com.example.tutoAPI.product.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String Email;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;


    public Supplier() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
