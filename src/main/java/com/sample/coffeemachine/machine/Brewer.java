package com.sample.coffeemachine.machine;

import static com.sample.coffeemachine.config.Constant.PREPARATION_TIME;
import static com.sample.coffeemachine.model.OutletStatus.BREWING;
import static com.sample.coffeemachine.model.OutletStatus.IDLE;

import java.util.Map;

import lombok.Setter;
import lombok.SneakyThrows;

import com.sample.coffeemachine.beverages.BeverageType;
import com.sample.coffeemachine.config.IngredientsType;
import com.sample.coffeemachine.config.RequiredIngredients;
import com.sample.coffeemachine.exceptions.RequiredQuantityNotAvailableException;
import com.sample.coffeemachine.model.AvailableResources;
import com.sample.coffeemachine.model.Outlet;

public class Brewer implements Runnable {
    private final AvailableResources availableResources;
    @Setter
    private Outlet outlet;
    @Setter
    private BeverageType beverageType;

    public Brewer(AvailableResources availableResources) {
        this.availableResources = availableResources;
    }

    private boolean brew() throws InterruptedException {
        Map<IngredientsType, Double> availableQuantities = availableResources.getAvailableQuantities();
        System.out.println("Preparing " + beverageType + " .....");

        synchronized (this) {
            for (Map.Entry<IngredientsType, Double> requiredIngredient : RequiredIngredients
                    .getRequiredIngredientQuantity(beverageType).entrySet()) {
                if (availableQuantities.get(requiredIngredient.getKey()) < requiredIngredient.getValue()) {
                    outlet.updateStatus(IDLE);
                    throw new RequiredQuantityNotAvailableException(beverageType, requiredIngredient.getKey());
                }
            }

            outlet.updateStatus(BREWING);

            for (Map.Entry<IngredientsType, Double> requiredIngredient : RequiredIngredients
                    .getRequiredIngredientQuantity(beverageType).entrySet()) {
                availableResources.decreaseQuantityOf(requiredIngredient.getKey(), requiredIngredient.getValue());
            }
        }
        Thread.sleep(PREPARATION_TIME);
        outlet.updateStatus(IDLE);
        System.out.println(beverageType + " is prepared");

        return true;
    }

    @SneakyThrows
    @Override
    public void run() {
        brew();
    }
}
