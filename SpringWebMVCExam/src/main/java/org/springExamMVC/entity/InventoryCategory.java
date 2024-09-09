package org.springExamMVC.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory_category")
public class InventoryCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_Id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
}
