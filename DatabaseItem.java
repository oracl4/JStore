/**
Mahdi Yusuf
1606825341
**/

public class DatabaseItem{
    private String listItem[];
    private Item item;

    public DatabaseItem(){
    }
    
    public boolean addItem(Item item){
    	return true;
    }
    
    public boolean removeItem(Item item){
    	return true;
    }
    
    public Item getItem(){
    	return item;
    }

    public String[] getItemDatabase(){
    	return listItem;
    }
}
