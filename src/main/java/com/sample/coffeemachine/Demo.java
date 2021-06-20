package com.sample.coffeemachine;

import static com.sample.coffeemachine.beverages.BeverageType.HOT_WATER;

import com.sample.coffeemachine.machine.CoffeeMachine;

public class Demo {
    private static CoffeeMachine coffeeMachine;

    public static void main(String[] args) throws InterruptedException {
        coffeeMachine = new CoffeeMachine(5);

        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(2, COFFEE);
        coffeeMachine.brewBeverage(3, HOT_TEA);
    }
}
