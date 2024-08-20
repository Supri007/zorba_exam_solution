package org.example.Execution;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.Entity.Customer;
import org.example.Entity.Product;
import org.example.Entity.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ImportToDatabase {
    public static void main(String[] args) {

        //Upload data to db
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ProductType.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Customer.class);

        Scanner sc = new Scanner(System.in);
        //Create List of Product type
        List<ProductType> prodTypeList = new ArrayList<>();
        prodTypeList.add(Utility.CreateProductType("Grocery", 30));
        prodTypeList.add(Utility.CreateProductType("Cosmetics", 50));
        prodTypeList.add(Utility.CreateProductType("DairyProduct", 35));

        //Create customer info
        Customer customer = Utility.GetCustomerInfo(sc);
        //Create product info
        Product product = Utility.GetProductInfo(sc);
        sc.close();
        //Get product type
        String prodType = "";
        List<String> dairyProductsList = Arrays.asList("milk","butter","paneer");
        List<String> cosmeticsList = Arrays.asList("facewash","soap","detergent");
        List<String> groceryList = Arrays.asList("rice","flour","vegetables");

        if (dairyProductsList.contains(product.productName.toLowerCase())){
            prodType = "DairyProduct";
        }
        else if (cosmeticsList.contains(product.productName.toLowerCase())){
            prodType = "Cosmetics";
        }
        else if (groceryList.contains(product.productName.toLowerCase())){
            prodType = "Grocery";
        }

        //Create SessionFactory Object from Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        System.out.println("Table created successfully");
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for(ProductType type: prodTypeList){
                session.merge(type);
            }
            //Query from database
            //Session session1 = sessionFactory.openSession();
            CriteriaBuilder queryCriteria = session.getCriteriaBuilder();
            CriteriaQuery<ProductType> productQuery = queryCriteria.createQuery(ProductType.class);
            Root<ProductType> fromProduct = productQuery.from(ProductType.class);
            productQuery.select(fromProduct).where(queryCriteria.equal(fromProduct.get("productType"), prodType));
            Query query = session.createQuery(productQuery);
            List<ProductType> prodTypeaFromDB = query.list();

            customer.productPrice = prodTypeaFromDB.get(0).rate * product.productQuantity;
            System.out.println("Product Type added successfully");
            session.merge(customer);
            System.out.println("Customer added successfully");
            session.merge(product);
            System.out.println("Product added successfully");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
