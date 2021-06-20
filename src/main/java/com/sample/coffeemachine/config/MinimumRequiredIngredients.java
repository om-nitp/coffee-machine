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

public class MinimumRequiredIngredients {
    public static Map<IngredientsType, Double> minimumRequiredIngredient;

    static {
        minimumRequiredIngredient = new HashMap<>();
        minimumRequiredIngredient.put(WATER, 200.0);
        minimumRequiredIngredient.put(MILK, 100.0);
        minimumRequiredIngredient.put(SUGAR_SYRUP, 50.0);
        minimumRequiredIngredient.put(GINGER_SYRUP, 20.0);
        minimumRequiredIngredient.put(TEA_LEAVES_SYRUP, 20.0);
        minimumRequiredIngredient.put(GREEN_MIXTURE, 15.0);
        minimumRequiredIngredient.put(ELAICHI_SYRUP, 20.0);
        minimumRequiredIngredient.put(COFFEE_SYRUP, 25.0);
    }
}
