package com.myShop.sprint2;

public abstract class AbstractProcess {

    public void process(Orderable item) {
        this.stepBefore();
        this.action(item);
        this.stepAfter();
    }

    private void stepBefore() {
        System.out.println("Starting process...");
    }

    private void stepAfter() {
        System.out.println("Saved!...");
    }

    abstract void action(Orderable item);
}
