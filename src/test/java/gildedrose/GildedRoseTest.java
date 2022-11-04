package gildedrose;

import gildedrose.Item;
import gildedrose.Shop;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void should_update_quality() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(5, 8));
        Shop shop = new Shop(items);
        shop.updateQuality();
        assertEquals(7, shop.items.get(0).getQuality());
        assertEquals(4, shop.items.get(0).getSellIn());
    }

}
