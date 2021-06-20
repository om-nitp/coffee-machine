package com.sample.coffeemachine;

import static com.sample.coffeemachine.beverages.BeverageType.HOT_WATER;

import com.sample.coffeemachine.machine.CoffeeMachine;

public class Demo {
    private static CoffeeMachine coffeeMachine;

    public static void main(String[] args) throws InterruptedException {
        coffeeMachine = new CoffeeMachine(5);

        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        Thread.sleep(1000);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(1, HOT_WATER);
    }
}
