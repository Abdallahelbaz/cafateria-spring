package edu.cafeteria.Services;

import edu.cafeteria.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Qualifier("itemServiceProxy")
public class ItemServiceProxy implements ItemService {

    @Autowired
    private ItemServiceImpl itemService;

    @Override
    public List<Item> getAllItems() {
        System.out.println("Fetching all items...");
        return itemService.getAllItems();
    }

    @Override
    public Item getItemById(Long id) {
        System.out.println("Fetching item with ID: " + id);
        return itemService.getItemById(id);
    }

    @Override
    public void saveItem(Item item) {
        System.out.println("Saving item: " + item.getName());
        itemService.saveItem(item);
    }

    @Override
    public void deleteItem(Long id) {
        System.out.println("Deleting item with ID: " + id);
        itemService.deleteItem(id);
    }

    @Override
    public void updateItem(Long id, Item item) {
        System.out.println("Updating item with ID: " + id);
        itemService.updateItem(id, item);
    }

    @Override
    public List<Item> searchItemsByName(String query) {
        System.out.println("Searching items by name: " + query);
        return itemService.searchItemsByName(query);
    }
}
