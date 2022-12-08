package gildedrose.CoreDomain;

import java.io.FileNotFoundException;
import java.util.List;


public interface ItemsRepository {

     List<Item> getInventory() throws FileNotFoundException;

     void saveInventory(List<Item> items) throws FileNotFoundException;

     Item findItem(String type,int quality) throws FileNotFoundException;

     void updateInventory(Item item) throws FileNotFoundException;

}
