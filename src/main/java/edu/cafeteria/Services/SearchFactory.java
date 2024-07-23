package edu.cafeteria.Services;

public class SearchFactory {



	 public static Search getSearch(String sort) {
	        if (sort == null) {
	            return null;
	        }
	        if (sort.equalsIgnoreCase("asc")) {
	            return new AscendingSearch();
	        } else if (sort.equalsIgnoreCase("desc")) {
	            return new DescendingSearch();
	        }
	        return null;
	 }


}
