package edu.cafeteria.Services;
 

import edu.cafeteria.model.Item;
import edu.cafeteria.model.Order;
import edu.cafeteria.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService  {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
    

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    public void updateItem(Long id, Item item) {
//        itemRepository.updateItem(id, item.getName(), item.getPhotoUrl(), item.getPrice());
//        deleteItem(  id);
        
        Item itemToUpdate = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));
        itemToUpdate.setCart(item.getCart());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setName(item.getName());
        itemToUpdate.setOrder(item.getOrder());
        itemToUpdate.setPhotoUrl(item.getPhotoUrl());
        itemToUpdate.setPrice(item.getPrice());
        
        itemRepository.save(itemToUpdate);
    }

	public List<Item> searchItemsByName(String query) {
		return itemRepository.findByNameContainingIgnoreCase(query);
	}
}

