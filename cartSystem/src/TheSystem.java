

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TheSystem {
    private HashMap<String, Item> itemCollection;
    
    //Constructor
    protected TheSystem() throws FileNotFoundException {
        itemCollection = new HashMap<String, Item>();

        if( this instanceof AppSystem){
        	
        	try {
	        	//load the items from the sample file
	        	File file = new File("C:\\Users\\OWNER\\Desktop\\SBA\\sample.txt");
	        	Scanner sc = new Scanner(file); 
	        	  
	            // we just need to use 2 blanks as delimiter 
	            sc.useDelimiter("  "); 
	            
	            while(sc.hasNext()){
		            //get the type
		            String type = sc.next();
		            //get the description
		            String desc = sc.next();
		            //get the price 
		            double price = sc.nextDouble();
		            //get the available quantity
		            String sQty = sc.nextLine().trim();
		            int aQty = Integer.parseInt(sQty);
		            
		          //create an item
		            Item item = new Item(type, desc, price, aQty);
		            
		           //Add it to the collection
		            itemCollection.put(type, item);
	            }
	            //close the scanner
	            sc.close();
        	}
        	catch(Exception ex) {
        		System.out.printf("Error reading from file: %s", ex.getMessage());
        	}
        	
        }
         
    }
    
    //create a new hashmap and copy from the private one and return the new one
    public HashMap<String, Item> getItemCollection(){
    	HashMap<String, Item> newHashMap = new HashMap<String, Item>(); 
    	
    	newHashMap = (HashMap<String, Item>) itemCollection.clone();
    	
    	return newHashMap;
    	
    }
    
    //assign the hashmap to this one
    public void setItemCollection(HashMap<String, Item> copy ){
      itemCollection = copy;
    }
    
    //If it is already in the collection, 
    //then check if the item is available, 
    //If it is available, increase the quantity by one, 
    //otherwise, don't add the item. If the item is not already 
    //in the collection, just add it to the collection.
    public Boolean add(Item item) {
    	
    	//check to see if it's in the collection
    	if(itemCollection.containsKey(item.getName())){
    		//get it 
    		Item itemInColl = itemCollection.get(item.getName());
    		int qty = itemInColl.getQty();
    		if( qty < itemInColl.getAQty()) {
    			itemInColl.setQty( qty + 1 );
    			itemCollection.replace(item.getName(), itemInColl);
    		}
    		else return false;
    	}
    	else { //add it
    		itemCollection.put(item.getName(), item);
    	}
    		
    	return true;
    }
      
    //This method takes as a parameter the name of the item to be removed. 
    //First check if the item is in the collection, 
    //if it is, then removes it and returns the Item object being removed.
    //If is not in the collection then return null
    //Decrement from the cart if more than one
    public Item remove(String itemName) {
        Item item = null;

        if(itemCollection.containsKey(itemName))
    		item = itemCollection.get(itemName);
    		
    	//if more than one then just decrement
        if((this instanceof CartSystem) && item != null && item.getQty() > 1)
        		item.setQty( item.getQty() - 1);		
        else  //if the last one remove 
        	itemCollection.remove(itemName);
        
        return item;
    }
    
    //This method takes Item object and an Integer (current) as its
    //parameters, 
    //the integer represents how many times a single item has been 
    //added to the cart.Then it checks if the item's quantity 
    //(item.getQuantity() )+ current is greater than the item's 
    //available quantity (item.getAvailableQuatity()); 
    //If it is, then display the following message. 
    //“System is unable to add [item.getQuantity() + current] 
    //[item’s name]”. 
    //“System can only add [item’s Quantity] [item’s name].  
    //Otherwise, if if the item's quantity (item.getQuantity() )+ current
    //is lower than the item's available quantity (item.getAvailableQuatity()),
    //return true.
    public Boolean checkAvailability(Item item, Integer current) {
    	
    	if(item.getQty() + current > item.getAQty()) {
    		
    		System.out.printf("System is unable to add %d for %s", 
    				item.getQty() + current, item.getName());
    		System.out.printf("System can only add %d for %s", 
    				item.getAQty() - item.getQty(), item.getName());
    		return false;
    	}
    	else 
    		return true;
    }
}
