package gildedrose;

import java.util.ArrayList;

public class Shop {

    public ArrayList<Item> items;

    public Shop(ArrayList<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            item.update();
          }
        }
    };

