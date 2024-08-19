package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;
    @Column(name = "cust_id")
    public String custId;
    @Column(name = "cust_name")
    public String customerName;
    @Column(name = "cust_email")
    public String customerEmail;
    @Column(name = "cust_mobile")
    public long customerMobile;
    @Column(name = "finalProductPrice")
    public double productPrice;

}
