package gildedrose.core.domain;

import gildedrose.core.domain.item.Item;

import java.io.FileNotFoundException;
import java.util.List;


public interface ItemsGateway {

     List<Item> getInventory() ;

     void saveInventory(List<Item> items) ;

     Item findItem(String type,int quality) ;

     void updateInventory(Item item) ;

}
