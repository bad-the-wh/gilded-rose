package gildedrose.Persistance;

import gildedrose.CoreDomain.Item;
import gildedrose.CoreDomain.ItemsRepository;
import lombok.*;

import java.io.FileNotFoundException;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class InMemoryItemsRepository implements ItemsRepository {
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
