package org.example.Execution;

import org.example.RentFlat.RentOfFlat;
import org.example.RentFlat.RentOfOneBHKFlat;
import org.example.RentFlat.RentOfThreeBHKFlat;
import org.example.RentFlat.RentOfTwoBHKFlat;
import org.example.SelfOwned.SelfOwnedFlat;
import org.example.SelfOwned.SelfOwnedOneBHKFlat;
import org.example.SelfOwned.SelfOwnedThreeBHKFlat;
import org.example.SelfOwned.SelfOwnedTwoBHKFlat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteRates {
    public static void main(String[] args) {

        ApplicationContext cont = new ClassPathXmlApplicationContext("bean.xml");
        int noOfPerson = 5;

        //For Rent Of Flat
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

        //For SelfOwnedFlat
        Float length = 5.5f;
        Float breadth = 10.7f;
        Float height = 15f;

        SelfOwnedFlat sfOwnedFlat = cont.getBean(SelfOwnedFlat.class);

        SelfOwnedOneBHKFlat selfOne = sfOwnedFlat.getSelfOne();
        float totalSelfOneRate = selfOne.finalPriceOfFlat(length, breadth, height);
        System.out.println("Rate of Self Owned One BHK Flat is: " + totalSelfOneRate);

        SelfOwnedTwoBHKFlat selfTwo = sfOwnedFlat.getSelfTwo();
        float totalSelfTwoRate = selfTwo.finalPriceOfFlat(length, breadth, height);
        System.out.println("Rate of Self Owned Two BHK Flat is: " + totalSelfTwoRate);

        SelfOwnedThreeBHKFlat selfThree = sfOwnedFlat.getSelfThree();
        float totalSelfThreeRate = selfThree.finalPriceOfFlat(length, breadth, height);
        System.out.println("Rate of Self Owned Three BHK Flat is: " + totalSelfThreeRate);



    }
}
