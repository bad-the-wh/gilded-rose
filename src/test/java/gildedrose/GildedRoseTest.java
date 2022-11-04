package gildedrose;

import gildedrose.Item;
import gildedrose.Shop;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void should_update_generic_quality() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new GenericItem(5, 8));
        items.add(new GenericItem(0, 8));
        items.add(new GenericItem(0, 1));
        Shop shop = new Shop(items);
        items.get(0).update();
        items.get(1).update();
        items.get(2).update();
        assertEquals(7, shop.items.get(0).getQuality());
        assertEquals(4, shop.items.get(0).getSellIn());
        assertEquals(6, shop.items.get(1).getQuality());
        assertEquals(0, shop.items.get(1).getSellIn());
        assertEquals(0, shop.items.get(2).getQuality());
        assertEquals(0, shop.items.get(2).getSellIn());
    }

    @Test
    void should_update_aging_quality() {

    }

}
