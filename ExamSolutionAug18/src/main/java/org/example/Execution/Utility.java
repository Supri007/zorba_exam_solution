package org.example.Execution;

import org.example.Entity.Customer;
import org.example.Entity.Product;
import org.example.Entity.ProductType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    public static ProductType CreateProductType(String prodType, double rate){
        ProductType productType = new ProductType(prodType, rate);
        return productType;
    }

    public static Customer GetCustomerInfo(Scanner sc){
        Customer customer = new Customer();
        System.out.println("Please enter name: ");
        customer.customerName = sc.nextLine();
        System.out.println("Please enter email address: ");
        customer.customerEmail = sc.nextLine();
        System.out.println("Please enter mobile number: ");
        customer.customerMobile = sc.nextLong();
        sc.nextLine();
        if (Integer.toString((int)customer.customerMobile).length() != 10){
            throw new InputMismatchException("Mobile number should be 10 digit. Please try again");
        }
        return customer;
    }

    public static Product GetProductInfo(Scanner sc){
        Product product = new Product();
        System.out.println("Please enter product Id: ");
        product.productId = sc.nextLine();
        //Validate user input
        ValidateInput(product.productId);
        System.out.println("Please enter product name: ");
        product.productName = sc.nextLine();
        System.out.println("Please enter product quantity: ");
        product.productQuantity = sc.nextDouble();
        sc.nextLine();
        System.out.println("Please enter customer Id: ");
        product.custId = sc.nextLine();
        //Validate user input
        ValidateInput(product.custId);
        System.out.println("Please enter product type: ");
        product.productType = sc.nextLine();
        return product;
    }

    public static void ValidateInput(String input){
        if (input.length() != 3){
            throw new InputMismatchException("Input is not valid please try again.");
        }
        if (Character.isAlphabetic(input.charAt(0)) &&
        Character.isDigit(input.charAt(1)) &&
                Character.isDigit(input.charAt(2))){
            System.out.println("Input Id is valid");
        }
        else{
            throw new InputMismatchException("Input Id is not valid should be in the format of P01 or C01");
        }
    }
}
