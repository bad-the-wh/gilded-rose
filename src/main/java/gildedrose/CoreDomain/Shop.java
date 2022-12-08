package gildedrose.CoreDomain;

import lombok.*;

import java.io.FileNotFoundException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Shop {

    private ItemsRepository repository;

    public void updateQuality() throws FileNotFoundException {
        List<Item> items = repository.getInventory();
        for (Item item : items) {
            item.update();
        }
        this.repository.saveInventory(items);
    }

    public void updateInventory(Item item) throws FileNotFoundException {

        repository.updateInventory(item);
    }

    public void sellItem(String type, int quality) throws FileNotFoundException {

        Item item = repository.findItem(type,quality);
        updateInventory(item);

    }

}
