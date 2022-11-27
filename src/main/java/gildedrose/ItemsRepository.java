package gildedrose;

import java.util.List;

public interface ItemsRepository {

     List<Item> getInventory();

     void saveInventory(List<Item> items);

     Item findItem(String type, int quality) throws ItemNotFoundException;

     void deleteItem(Item item);

}
