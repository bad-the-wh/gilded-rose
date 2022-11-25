package gildedrose;

import java.util.List;

public class Shop {

    private ItemsRepository repository;

    public Shop(ItemsRepository repository) {
        this.repository = repository;
    }

    public void updateQuality() {
        List<Item> items = this.repository.getInventory();
        for (Item item : items) {
            item.update();
            }
        this.repository.saveInventory(items);
        }
    };

