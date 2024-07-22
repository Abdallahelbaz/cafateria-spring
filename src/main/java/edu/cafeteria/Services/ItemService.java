package edu.cafeteria.Services;

import java.util.List;

import edu.cafeteria.model.Item;

public interface ItemService {
	 List<Item> getAllItems();
	    Item getItemById(Long id);
	    void saveItem(Item item);
	    void deleteItem(Long id);
	    void updateItem(Long id, Item item);
	    List<Item> searchItemsByName(String query);
}
