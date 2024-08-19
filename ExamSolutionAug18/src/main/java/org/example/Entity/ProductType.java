package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_type")
@Data
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_type_id")
    public Integer prodTypeId;
    @Column(name = "product_type")
    public String productType;
    @Column(name = "rate")
    public double rate;

    public ProductType() {
    }

    public ProductType(String productType, double rate){
        this.productType = productType;
        this.rate = rate;
    }
}
