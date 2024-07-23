package edu.cafeteria.Services;

import edu.cafeteria.model.Item; 
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

public class AscendingSearch extends Search {
	 @Override
	    public List<Item> search(List<Item> items) {
 
		 return items.stream()
                 .sorted(Comparator.comparing(Item::getPrice))
                 .collect(Collectors.toList());
	    }
}
