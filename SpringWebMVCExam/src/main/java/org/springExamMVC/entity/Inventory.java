package org.springExamMVC.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer id;
    @Column(name = "inventory_name")
    private String name;
    @Column(name = "inventory_quantity")
    private Integer quantity;
    @Column(name = "inventory_price")
    private double price;
    @Column(name = "inventory_image")
    private String image;
    @Column(name = "inventory_description")
    private String description;
}
