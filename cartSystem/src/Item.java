

public class Item{
    private String itemName;
    private String itemDesc;
    private Double itemPrice;
    private Integer quantity;
    private Integer availableQuantity;
    /**
     * @return the itemName
     */
  //Constructor
    public Item() {
    	quantity = 1;
    }
    
    public Item(String Name, String Desc, Double Price, Integer AQty) {
    	this();
    	itemName = Name;
    	itemDesc = Desc;
    	itemPrice = Price;
    	availableQuantity = AQty;
    	
    }
    
    //getters and setters
    public void setName( String Name) { itemName = Name; }
    public String getName() { return itemName; }
    
    public void setDesc( String Desc) { itemDesc = Desc; }
    public String getDesc() { return itemDesc; }
    
    public void setPrice( Double Price) { itemPrice = Price; }
    public Double getPrice() { return itemPrice; }
    
    public void setQty( Integer Qty) { quantity = Qty; }
    public Integer getQty() { return quantity; }
    
    public void setAQty( Integer AQty) { availableQuantity = AQty; }
    public Integer getAQty() { return availableQuantity; }
}
