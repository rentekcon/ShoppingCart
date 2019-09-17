
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

public class CartSystem extends TheSystem{
	
	final double TAX = 0.05;
	
    public CartSystem() throws FileNotFoundException {
    }
    
    //This method takes no parameter 
    //and displays every item in the Cart system, 
    //along with the subtotal(the sum of the [item's price * quantity]
    //of the items in the cart), 
    //the tax which is the subtotal * 0.05, 
    //and the total which is the subtotal + tax
    public void display() {
      double subtotal = 0, tax, total;
      
      HashMap<String, Item> current = this.getItemCollection();
      
      // Iterate through HashMap entries(Key-Value pairs)
      for (Entry<String, Item> item : current.entrySet()) {
         System.out.printf("Menu Item %s ", item.getKey());
         System.out.printf("Qty: %d\r\n",item.getValue().getQty());
         subtotal += item.getValue().getPrice() * item.getValue().getQty();
      }
      
      //display totals
      tax = subtotal * TAX;
      total = subtotal + tax;
      
      System.out.printf("Subtotal: %f, Tax: %f, Total: %f", subtotal, tax, total);
    }
      
      
} // end of CartSystem
