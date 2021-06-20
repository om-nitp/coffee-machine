package com.sample.coffeemachine.machine;

import static com.sample.coffeemachine.model.OutletStatus.IDLE;
import static com.sample.coffeemachine.model.OutletStatus.IN_PROGRESS;

import java.util.HashMap;
import java.util.Map;

import com.sample.coffeemachine.beverages.BeverageType;
import com.sample.coffeemachine.config.IngredientsType;
import com.sample.coffeemachine.config.InitialResources;
import com.sample.coffeemachine.model.AvailableResources;
import com.sample.coffeemachine.model.Outlet;

public class CoffeeMachine {
    private final Map<Integer, Outlet> outlets;
    private final AvailableResources availableResources;
    private final Brewer brewer;

    public CoffeeMachine(int totalOutlets) {
        this.availableResources = new AvailableResources(InitialResources.initialResources);
        this.outlets = new HashMap<>();
        for(int i=1; i<=totalOutlets; i++) {
            outlets.put(i, new Outlet(i, "Outlet number: " + i));
        }
        this.brewer = new Brewer(availableResources);
    }

    public void brewBeverage(int outletId, BeverageType beverageType) {
        if(!outlets.containsKey(outletId)) {
            System.out.println(outletId + " does not exist");
            return;
        }
        
        Outlet outlet = outlets.get(outletId);
        if (outlet.getOutletStatus() != IDLE) {
            System.out.println("Outlet number " + outletId + " is not available");
            return;
        }
        outlet.updateStatus(IN_PROGRESS);

        Thread brewer = new Thread(new Brewer(availableResources, outlet, beverageType));
        brewer.start();
    }

    public void addQuantity(IngredientsType type, double quantity) {
        availableResources.addQuantityOf(type, quantity);
    }
}
