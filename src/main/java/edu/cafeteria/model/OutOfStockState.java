package edu.cafeteria.model;

public class OutOfStockState implements ItemState {

    @Override
    public void handleStateChange(Item item) {
        
        System.out.println("Item is out of stock.");
    }

    @Override
    public String getStateName() {
        return "OutOfStock";
    }
}
