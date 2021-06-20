package com.sample.coffeemachine.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;

import com.sample.coffeemachine.config.IngredientsType;
import com.sample.coffeemachine.config.MinimumRequiredIngredients;

public class AvailableResources {
    @Getter
    private final Map<IngredientsType, Double> availableQuantities;

    public AvailableResources(Map<IngredientsType, Double> initialResources) {
        this.availableQuantities = new HashMap<>();

        for (Map.Entry<IngredientsType, Double> entry : initialResources.entrySet())
            availableQuantities.put(entry.getKey(), entry.getValue());
    }

    public void addQuantityOf(@NonNull IngredientsType ingredient, @NonNull double amount) {
        synchronized (this) {
            availableQuantities.put(ingredient, amount + availableQuantities.getOrDefault(ingredient, 0.0));
        }
    }

    public void decreaseQuantityOf(@NonNull IngredientsType ingredient, @NonNull double amount) {
        availableQuantities.put(ingredient, availableQuantities.get(ingredient) - amount);

        if (availableQuantities.get(ingredient) < MinimumRequiredIngredients.minimumRequiredIngredient.get(ingredient)) {
            System.out.println("Alert: " + ingredient + " is running low");
        }
    }
}
