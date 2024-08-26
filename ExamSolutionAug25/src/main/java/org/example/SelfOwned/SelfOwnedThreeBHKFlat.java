package org.example.SelfOwned;

public class SelfOwnedThreeBHKFlat {

    public float finalPriceOfFlat(float length, float breadth, float height){
        return 50000 * calculatePlot(length, breadth, height);
    }

    public float calculatePlot(float length, float breadth, float height){
        return length * breadth * height;
    }
}
