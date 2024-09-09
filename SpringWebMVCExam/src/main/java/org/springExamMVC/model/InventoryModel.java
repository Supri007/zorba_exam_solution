package org.springExamMVC.model;

import lombok.Data;

@Data
public class InventoryModel {
    private Integer id;
    private String name;
    private Integer quantity;
    private double price;
    private String image;
    private String description;
}
