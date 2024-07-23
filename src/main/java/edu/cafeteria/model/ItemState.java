package edu.cafeteria.model;

public interface ItemState {
	void handleStateChange(Item item);
    String getStateName();
}
