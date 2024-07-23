package edu.cafeteria.Services;

import edu.cafeteria.model.Item;
import edu.cafeteria.Repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("itemServiceImpl")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(Long id, Item item) {
        Item itemToUpdate = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));
        itemToUpdate.setCart(item.getCart());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setName(item.getName());
        itemToUpdate.setOrder(item.getOrder());
        itemToUpdate.setPhotoUrl(item.getPhotoUrl());
        itemToUpdate.setPrice(item.getPrice());
        itemRepository.save(itemToUpdate);
    }

    @Override
    public List<Item> searchItemsByName(String query) {
        return itemRepository.findByNameContainingIgnoreCase(query);
    }
}

 
