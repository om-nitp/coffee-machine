package com.sample.coffeemachine.beverages;

import lombok.Getter;

public abstract class Beverage {
    @Getter
    private final BeverageType beverageType;

    public Beverage(BeverageType beverageType) {
        this.beverageType = beverageType;
    }
}
