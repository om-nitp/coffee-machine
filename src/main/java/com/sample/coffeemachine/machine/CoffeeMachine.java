package com.sample.coffeemachine.machine;

import static com.sample.coffeemachine.model.OutletStatus.IDLE;
import static com.sample.coffeemachine.model.OutletStatus.IN_PROGRESS;

import java.util.ArrayList;
import java.util.List;

import com.sample.coffeemachine.beverages.Beverage;
import com.sample.coffeemachine.beverages.BeverageType;
import com.sample.coffeemachine.config.IngredientsType;
import com.sample.coffeemachine.config.InitialResources;
import com.sample.coffeemachine.exceptions.SelectedOutletNotAvailableException;
import com.sample.coffeemachine.model.AvailableResources;
import com.sample.coffeemachine.model.Outlet;

public class CoffeeMachine {
    private final List<Outlet> outlets;
    private final AvailableResources availableResources;
    private final Brewer brewer;

    public CoffeeMachine(int totalOutlets) {
        this.availableResources = new AvailableResources(InitialResources.initialResources);
        this.outlets = new ArrayList<>();
        for(int i=1; i<=totalOutlets; i++) {
            outlets.add(new Outlet(i, "Outlet number: " + i));
        }
        this.brewer = new Brewer(availableResources);
    }

    public void brewBeverage(int outletId, BeverageType beverageType) throws InterruptedException {
        Outlet outlet = outlets.get(outletId-1);
        synchronized (this) {
            if (outlet.getOutletStatus() != IDLE) {
                System.out.println("Outlet number " + outletId + " is not available");
                return;
            }
        }
        outlet.updateStatus(IN_PROGRESS);

        brewer.setOutlet(outlet);
        brewer.setBeverageType(beverageType);
        Thread thread = new Thread(brewer);
        try {
            thread.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addQuantity(IngredientsType type, double quantity) {
        availableResources.addQuantityOf(type, quantity);
    }
}
