package com.sample.coffeemachine.config;

import static com.sample.coffeemachine.config.IngredientsType.COFFEE_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.ELAICHI_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.GINGER_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.GREEN_MIXTURE;
import static com.sample.coffeemachine.config.IngredientsType.MILK;
import static com.sample.coffeemachine.config.IngredientsType.SUGAR_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.TEA_LEAVES_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.WATER;

import java.util.HashMap;
import java.util.Map;

public class InitialResources {
    public static Map<IngredientsType, Double> initialResources;

    static {
        initialResources = new HashMap<>();
        initialResources.put(WATER, 500.0);
        initialResources.put(MILK, 500.0);
        initialResources.put(SUGAR_SYRUP, 100.0);
        initialResources.put(GINGER_SYRUP, 100.0);
        initialResources.put(TEA_LEAVES_SYRUP, 100.0);
        initialResources.put(GREEN_MIXTURE, 15.0);
        initialResources.put(ELAICHI_SYRUP, 50.0);
        initialResources.put(COFFEE_SYRUP, 250.0);
    }
}
