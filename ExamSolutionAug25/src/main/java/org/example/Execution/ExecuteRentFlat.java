package org.example.Execution;

import org.example.RentFlat.RentOfFlat;
import org.example.RentFlat.RentOfOneBHKFlat;
import org.example.RentFlat.RentOfThreeBHKFlat;
import org.example.RentFlat.RentOfTwoBHKFlat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteRentFlat {
    public static void main(String[] args) {

        ApplicationContext cont = new ClassPathXmlApplicationContext("bean.xml");
        int noOfPerson = 5;

        RentOfFlat rof = cont.getBean(RentOfFlat.class);
        RentOfOneBHKFlat rof1 = rof.getRentOne();
        int totalCostOne = rof1.calculateRentOfFlat(5);
        System.out.println("Rent of One BHK Flat is: " + totalCostOne);

        RentOfTwoBHKFlat rof2 = rof.getRentTwo();
        int totalCostTwo = rof2.calculateRentOfFlat(5);
        System.out.println("Rent of Two BHK Flat is: " + totalCostTwo);

        RentOfThreeBHKFlat rof3 = rof.getRentThree();
        int totalCostThree = rof3.calculateRentOfFlat(5);
        System.out.println("Rent of Three BHK Flat is: " + totalCostThree);

    }
}
