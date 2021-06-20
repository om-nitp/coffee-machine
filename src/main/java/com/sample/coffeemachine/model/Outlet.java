package com.sample.coffeemachine.model;

import lombok.Getter;

public class Outlet {
    private final int id;
    @Getter
    private final String outletName;
    @Getter
    private volatile OutletStatus outletStatus;

    public Outlet(int id, String name) {
        this.id = id;
        this.outletName = name;
        this.outletStatus = OutletStatus.IDLE;
    }

    public void updateStatus(OutletStatus updatedStatus) {
        synchronized (this) {
            outletStatus = updatedStatus;
        }
    }
}
