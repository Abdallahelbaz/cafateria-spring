package edu.cafeteria.model;

public class NotAvailableState implements ItemState{

    @Override
    public void handleStateChange(Item item) {

        System.out.println("Item is Not available.");
    }

    @Override
    public String getStateName() {
        return "Not Available";
    }
}
