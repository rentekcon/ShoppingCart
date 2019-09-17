

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;



public class AppSystem extends TheSystem {
    public AppSystem() throws FileNotFoundException {
    }
    
    //This method takes no parameter 
    //and it should display every item in the App system.
    public void display() {
        HashMap<String, Item> current = this.getItemCollection();
      
     
        // Iterate through HashMap entries(Key-Value pairs)
        for (Entry<String, Item> item : current.entrySet()) {
           System.out.printf("Menu Item %s \tRating: %s \tPrice: %f \tQty: %d \tAQty: %d\r\n", item.getKey(),
        		  item.getValue().getDesc(), item.getValue().getPrice(), item.getValue().getQty(),
        		  item.getValue().getAQty());
           
       }

    }
    
    // This method takes an Item Object as a parameter. 
    //It checks if the item is already in the system. 
    //If it is, then display a message 
    //“[Item’s name] is already in the [name of the class calling this method]” 
    //and return false. 
    //If is not then add it and return true 
    public Boolean add(Item item) {
    	HashMap<String, Item> current = this.getItemCollection();
    	if(current.containsKey(item.getName())){
    		System.out.printf("s is already in the %s", item.getName(), current.getClass().getName());
    		return false;
    	}
    	else {
    		current.put(item.getName(), item);
    		setItemCollection(current);
    	}
    	return true;

    }
}
