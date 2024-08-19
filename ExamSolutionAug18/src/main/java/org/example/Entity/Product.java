package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;
    @Column(name = "product_id")
    public String productId;
    @Column(name = "product_name")
    public String productName;
    @Column(name = "product_quantity")
    public double productQuantity;
    //@ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "cust_id")
    public String custId;
    //@ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "prod_type_id")
    public Integer prodTypeId;

    public String productType;
}
