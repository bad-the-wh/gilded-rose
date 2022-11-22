package gildedrose;

import java.io.FileNotFoundException;
import java.util.List;

public class Shop {

    private ItemsRepository repository;

    public Shop(ItemsRepository repository) {
        this.repository = repository;
    }

    public void updateQuality() throws FileNotFoundException {
        List<Item> items = this.repository.getInventory();
        for (Item item : items) {
            item.update();
            }
        this.repository.saveInventory(items);
        }
    };

