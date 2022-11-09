package gildedrose;

import gildedrose.Item;
import gildedrose.Shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    Shop shop;

    @BeforeEach
    void setup() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new GenericItem(5, 8));
        items.add(new GenericItem(0, 8));
        items.add(new GenericItem(0, 1));

        items.add(new AgingItem(5, 8));
        items.add(new AgingItem(5, 50));

        items.add(new LegendaryItem(6, 80));

        items.add(new EventItem(12, 8));
        items.add(new EventItem(11, 50));
        items.add(new EventItem(9, 33));
        items.add(new EventItem(4, 21));
        items.add(new EventItem(0, 30));

        items.add(new ConjuredItem(5, 8));
        items.add(new ConjuredItem(0, 8));
        items.add(new ConjuredItem(0, 3));

        shop = new Shop(items);
        shop.updateQuality();
    }

    @Test
    void should_update_item() {
        assertEquals(4, shop.items.get(0).getSellIn());
        assertEquals(7, shop.items.get(0).getQuality());
    }

    @Test
    void should_decrease_quality_twice_as_fast_after_sellin() {
        assertEquals(6, shop.items.get(1).getQuality());
    }

    @Test
    void should_not_decrease_quality_under_zero() {
        assertEquals(0, shop.items.get(2).getQuality());
    }

    @Test
    void should_increase_agedbrie_quality() {
        assertEquals(9, shop.items.get(3).getQuality());
    }

    @Test
    void should_not_increase_quality_over_fity() {
        assertEquals(50, shop.items.get(4).getQuality());
    }

    @Test
    void should_not_changed_sulfuras_quality() {
        assertEquals(80, shop.items.get(5).getQuality());
    }

    @Test
    void should_increase_event_item_quality() {
        assertEquals(9, shop.items.get(6).getQuality());
        assertEquals(50, shop.items.get(7).getQuality());
    }

    @Test
    void should_increase_event_item_quality_ten_days_before() {
        assertEquals(35, shop.items.get(8).getQuality());
    }

    @Test
    void should_increase_event_item_quality_five_days_before() {
        assertEquals(24, shop.items.get(9).getQuality());
    }

    @Test
    void should_increase_event_item_quality_after_event() {
        assertEquals(0, shop.items.get(10).getQuality());
    }

    @Test
    void should_update_conjured_quality_twice_as_fast_as_generic() {
        assertEquals(6, shop.items.get(11).getQuality());
        assertEquals(4, shop.items.get(12).getQuality());
        assertEquals(0, shop.items.get(13).getQuality());
    }
}
