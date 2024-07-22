package edu.cafeteria.model;

public class AvailableState implements ItemState {

    @Override
    public void handleStateChange(Item item) {
        
        System.out.println("Item is now available.");
    }

    @Override
    public String getStateName() {
        return "Available";
    }
}
