package edu.cafeteria.Services;


import edu.cafeteria.model.Item;
import java.util.List;

public abstract class Search {
    
	public abstract List<Item> search(List<Item> items);
}