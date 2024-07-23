package edu.cafeteria.Services;

public class SearchFactory {
<<<<<<< HEAD

=======
>>>>>>> f4810c9af638d9b83a4a8f8b5e337c7a0132c43b
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
