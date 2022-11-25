package gildedrose;
import java.io.FileNotFoundException;
import java.util.List;


public interface ItemsRepository {

     List<Item> getInventory() throws FileNotFoundException;

     void saveInventory(List<Item> items) throws FileNotFoundException;

}
