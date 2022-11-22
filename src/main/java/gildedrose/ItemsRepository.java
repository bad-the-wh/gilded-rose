package gildedrose;
import java.util.List;


public interface ItemsRepository {
    
     List<Item> getInventory() ;

     void saveInventory(List<Item> items) ;
        
}