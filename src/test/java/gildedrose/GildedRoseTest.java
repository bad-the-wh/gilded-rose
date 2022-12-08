package gildedrose;

import gildedrose.CoreDomain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GildedRoseTest {

    @Mock
    Shop shop;

    List<Item> items;

    @Mock
    ItemsRepository repository;

    @BeforeEach
    void setup() throws FileNotFoundException {

       items = new ArrayList<Item>();

   }

    @Test
    void should_decrease_quality_genericItem() {

        items.add(GenericItem.builder().sellIn(5).quality(8).basePrice(100).build());

        items.get(0).update();

        assertNotNull(items.get(0));
        assertEquals(4, items.get(0).getSellIn());
        assertEquals(7, items.get(0).getQuality());
    }


    @Test
    void should_decrease_quality_twice_when_sellIn_under_zero_genericItem() throws FileNotFoundException {
        items.add(GenericItem.builder().sellIn(0).quality(8).basePrice(100).build());

        items.get(0).update();

        assertNotNull(items.get(0));
        assertEquals(0, items.get(0).getSellIn());
        assertEquals(6, items.get(0).getQuality());
    }

    @Test
    void should_not_decrease_quality_under_zero_genericItem() throws FileNotFoundException {
        items.add(GenericItem.builder().sellIn(5).quality(0).basePrice(100).build());

        items.get(0).update();

        assertEquals(4, items.get(0).getSellIn());
        assertEquals(0, items.get(0).getQuality());
    }

    @Test
    void should_increase_agingItem_quality() throws FileNotFoundException {
        items.add(AgingItem.builder().sellIn(5).quality(8).basePrice(100).build());

        items.get(0).update();

        assertEquals(4, items.get(0).getSellIn());
        assertEquals(9, items.get(0).getQuality());
    }

    @Test
    void should_not_increase_quality_over_fity() throws FileNotFoundException {
        items.add(AgingItem.builder().sellIn(5).quality(50).basePrice(100).build());

        items.get(0).update();

        assertEquals(4, items.get(0).getSellIn());
        assertEquals(50, items.get(0).getQuality());
    }

    @Test
    void should_not_upgrade_quality_when_sellin_equals_zero() throws FileNotFoundException {
        items.add(AgingItem.builder().sellIn(0).quality(10).basePrice(100).build());

        items.get(0).update();

        assertEquals(0, items.get(0).getSellIn());
        assertEquals(10, items.get(0).getQuality());
    }


    @Test
    void should_not_change_legendary_item_quality() throws FileNotFoundException {
        items.add(new LegendaryItem());

        items.get(0).update();

        assertEquals(0, items.get(0).getSellIn());
        assertEquals(80, items.get(0).getQuality());
    }

    @Test
    void should_increase_event_item_quality() throws FileNotFoundException {
        items.add(EventItem.builder().sellIn(11).quality(25).basePrice(100).build());

        items.get(0).update();

        assertEquals(10, items.get(0).getSellIn());
        assertEquals(26, items.get(0).getQuality());
    }

    @Test
    void should_increase_event_item_quality_ten_days_before() throws FileNotFoundException {
        items.add(EventItem.builder().sellIn(8).quality(20).basePrice(100).build());

        items.get(0).update();

        assertEquals(7, items.get(0).getSellIn());
        assertEquals(22, items.get(0).getQuality());
    }

    @Test
    void should_increase_event_item_quality_five_days_before() throws FileNotFoundException {
        items.add(EventItem.builder().sellIn(4).quality(35).basePrice(100).build());

        items.get(0).update();

        assertEquals(3, items.get(0).getSellIn());
        assertEquals(38, items.get(0).getQuality());
    }

    @Test
    void should_decrease_event_item_quality_after_event() throws FileNotFoundException {
        items.add(EventItem.builder().sellIn(0).quality(45).basePrice(100).build());

        items.get(0).update();

        assertEquals(0, items.get(0).getSellIn());
        assertEquals(0, items.get(0).getQuality());
    }

    @Test
    void should_update_conjured_quality() throws FileNotFoundException {
        items.add(ConjuredItem.builder().sellIn(10).quality(15).basePrice(100).build());

        items.get(0).update();

        assertEquals(9, items.get(0).getSellIn());
        assertEquals(13, items.get(0).getQuality());
    }

    @Test
    void should_update_conjured_quality_twice_as_fast_when_selln_reaches_zero() throws FileNotFoundException {
        items.add(ConjuredItem.builder().sellIn(0).quality(15).basePrice(100).build());

        items.get(0).update();

        assertEquals(0, items.get(0).getSellIn());
        assertEquals(11, items.get(0).getQuality());
    }

}
