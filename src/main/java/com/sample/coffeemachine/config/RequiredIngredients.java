package com.sample.coffeemachine.config;

import static com.sample.coffeemachine.beverages.BeverageType.BLACK_TEA;
import static com.sample.coffeemachine.beverages.BeverageType.COFFEE;
import static com.sample.coffeemachine.beverages.BeverageType.ELAICHI_TEA;
import static com.sample.coffeemachine.beverages.BeverageType.GREEN_TEA;
import static com.sample.coffeemachine.beverages.BeverageType.HOT_MILK;
import static com.sample.coffeemachine.beverages.BeverageType.HOT_TEA;
import static com.sample.coffeemachine.beverages.BeverageType.HOT_WATER;
import static com.sample.coffeemachine.config.IngredientsType.COFFEE_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.ELAICHI_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.GREEN_MIXTURE;
import static com.sample.coffeemachine.config.IngredientsType.MILK;
import static com.sample.coffeemachine.config.IngredientsType.SUGAR_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.TEA_LEAVES_SYRUP;
import static com.sample.coffeemachine.config.IngredientsType.WATER;

import java.util.HashMap;
import java.util.Map;

import com.sample.coffeemachine.beverages.BeverageType;

public class RequiredIngredients {
    private static final Map<BeverageType, Map<IngredientsType, Double>> requiredIngredients;

    static {
        requiredIngredients = new HashMap<>();
        requiredIngredients.put(HOT_WATER, getHotWaterQuantity());
        requiredIngredients.put(HOT_MILK, getHotMilkQuantity());
        requiredIngredients.put(GREEN_TEA, getGreenTeaQuantity());
        requiredIngredients.put(BLACK_TEA, getBlackTeaQuantity());
        requiredIngredients.put(ELAICHI_TEA, getElaichiTeaQuantity());
        requiredIngredients.put(HOT_TEA, getHotTeaQuantity());
        requiredIngredients.put(COFFEE, getCoffeeQuantity());
    }

    public static Map<IngredientsType, Double> getRequiredIngredientQuantity(BeverageType type) {
        return RequiredIngredients.requiredIngredients.get(type);
    }

    private static Map<IngredientsType, Double> getHotWaterQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(WATER, 50.0);
        return requiredQuantity;
    }

    private static Map<IngredientsType, Double> getHotMilkQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(MILK, 50.0);
        return requiredQuantity;
    }

    private static Map<IngredientsType, Double> getGreenTeaQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(WATER, 50.0);
        requiredQuantity.put(GREEN_MIXTURE, 10.0);
        return requiredQuantity;
    }

    private static Map<IngredientsType, Double> getBlackTeaQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(WATER, 50.0);
        requiredQuantity.put(SUGAR_SYRUP, 10.0);
        requiredQuantity.put(TEA_LEAVES_SYRUP, 10.0);
        return requiredQuantity;
    }

    private static Map<IngredientsType, Double> getElaichiTeaQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(WATER, 50.0);
        requiredQuantity.put(MILK, 10.0);
        requiredQuantity.put(SUGAR_SYRUP, 10.0);
        requiredQuantity.put(ELAICHI_SYRUP, 10.0);
        requiredQuantity.put(TEA_LEAVES_SYRUP, 10.0);
        return requiredQuantity;
    }

    private static Map<IngredientsType, Double> getHotTeaQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(WATER, 50.0);
        requiredQuantity.put(MILK, 10.0);
        requiredQuantity.put(SUGAR_SYRUP, 10.0);
        requiredQuantity.put(TEA_LEAVES_SYRUP, 10.0);
        return requiredQuantity;
    }

    private static Map<IngredientsType, Double> getCoffeeQuantity() {
        Map<IngredientsType, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(WATER, 50.0);
        requiredQuantity.put(MILK, 10.0);
        requiredQuantity.put(SUGAR_SYRUP, 10.0);
        requiredQuantity.put(COFFEE_SYRUP, 10.0);
        return requiredQuantity;
    }
}
