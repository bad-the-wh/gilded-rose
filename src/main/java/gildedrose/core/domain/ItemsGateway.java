package gildedrose.core.domain;

import gildedrose.core.domain.item.Item;

import java.io.FileNotFoundException;
import java.util.List;


public interface ItemsGateway {

     List<Item> getInventory() throws FileNotFoundException;

     void saveInventory(List<Item> items) throws FileNotFoundException;

     Item findItem(String type,int quality) throws FileNotFoundException;

     void updateInventory(Item item) throws FileNotFoundException;

}
