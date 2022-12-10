package gildedrose.persistance;

import gildedrose.core.domain.item.Item;
import gildedrose.core.domain.ItemsGateway;
import lombok.*;

import java.io.FileNotFoundException;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class InMemoryItemsGateway implements ItemsGateway {
    private List<Item> items;

    @Override
    public List<Item> getInventory() {

        return items;
    }

    @Override
    public void saveInventory(List<Item> items) throws FileNotFoundException {
        this.items=items;

    }

    @Override
    public Item findItem(String type, int quality) throws FileNotFoundException {

        Item result = null;

        for(Item i : items){

            if((i.getItemName() == type) && (i.getQuality() == quality)){

                result = i;

            }

        }

        return result;

    }

    @Override
    public void updateInventory(Item item) throws FileNotFoundException {

        List<Item> items = getItems();
        int i = 0;

        for (Item item1 : items){

            if(item1 == item){

                items.remove(i);

            }

            else i++;

        }

        saveInventory(items);

    }

}
