package com.sample.coffeemachine;

import static com.sample.coffeemachine.beverages.BeverageType.HOT_WATER;
import static com.sample.coffeemachine.beverages.BeverageType.HOT_TEA;
import static com.sample.coffeemachine.beverages.BeverageType.COFFEE;
import static com.sample.coffeemachine.beverages.BeverageType.BLACK_TEA;
import static com.sample.coffeemachine.beverages.BeverageType.GREEN_TEA;

import com.sample.coffeemachine.machine.CoffeeMachine;

public class Demo {
    private static CoffeeMachine coffeeMachine;

    public static void main(String[] args) throws InterruptedException {
        coffeeMachine = new CoffeeMachine(5);

        coffeeMachine.brewBeverage(1, HOT_WATER);
        coffeeMachine.brewBeverage(2, HOT_TEA);
        coffeeMachine.brewBeverage(3, COFFEE);
        coffeeMachine.brewBeverage(4, BLACK_TEA);
        coffeeMachine.brewBeverage(5, GREEN_TEA);
    }
}
