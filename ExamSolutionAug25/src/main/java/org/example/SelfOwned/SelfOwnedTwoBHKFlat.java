package org.example.SelfOwned;

public class SelfOwnedTwoBHKFlat {

    public float finalPriceOfFlat(float length, float breadth, float height){
        return 30000 * calculatePlot(length, breadth, height);
    }

    public float calculatePlot(float length, float breadth, float height){
        return length * breadth * height;
    }
}
