package edu.cafeteria.Services;


import java.util.stream.Collectors;
import edu.cafeteria.model.Item; 
import java.util.Comparator;
import java.util.List;

public class DescendingSearch extends Search {
    @Override
    public List<Item> search(List<Item> items) {
 
    
    	 return items.stream()
                 .sorted(Comparator.comparing(Item::getPrice).reversed())
                 .collect(Collectors.toList());
    }
}