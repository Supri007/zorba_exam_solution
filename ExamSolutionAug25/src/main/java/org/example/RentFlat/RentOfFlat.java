package org.example.RentFlat;

public class RentOfFlat {
    public RentOfOneBHKFlat rentOne;
    public RentOfTwoBHKFlat rentTwo;
    public RentOfThreeBHKFlat rentThree;

    public RentOfFlat(RentOfOneBHKFlat rentOne, RentOfTwoBHKFlat rentTwo, RentOfThreeBHKFlat rentThree) {
        this.rentOne = rentOne;
        this.rentTwo = rentTwo;
        this.rentThree = rentThree;
    }

    public RentOfOneBHKFlat getRentOne() {
        return rentOne;
    }

    public RentOfTwoBHKFlat getRentTwo() {
        return rentTwo;
    }

    public RentOfThreeBHKFlat getRentThree() {
        return rentThree;
    }
}
