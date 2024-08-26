package org.example.SelfOwned;

public class SelfOwnedFlat {
    public SelfOwnedOneBHKFlat selfOne;
    public SelfOwnedTwoBHKFlat selfTwo;
    public SelfOwnedThreeBHKFlat selfThree;

    public SelfOwnedFlat(SelfOwnedOneBHKFlat selfOne, SelfOwnedTwoBHKFlat selfTwo, SelfOwnedThreeBHKFlat selfThree) {
        this.selfOne = selfOne;
        this.selfTwo = selfTwo;
        this.selfThree = selfThree;
    }

    public SelfOwnedOneBHKFlat getSelfOne() {
        return selfOne;
    }

    public SelfOwnedTwoBHKFlat getSelfTwo() {
        return selfTwo;
    }

    public SelfOwnedThreeBHKFlat getSelfThree() {
        return selfThree;
    }
}
