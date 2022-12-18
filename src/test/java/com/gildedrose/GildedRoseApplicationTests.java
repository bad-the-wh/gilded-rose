package com.gildedrose;

import com.gildedrose.core.domain.*;
import com.gildedrose.core.domain.item.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class GildedRoseApplicationTests {

	@Qualifier("itemsGatewayImpl")
	@Autowired
	ItemsGateway repository;
	ShopInputBoundary shopInput;
	ShopOutputBoundary shopOutput;
	List<Item> items;

	@BeforeEach
	void setup() {
		
		shopInput = ShopInputBoundary.builder().repository(repository).shopBalance(0).build();
		shopOutput = ShopOutputBoundary.builder().repository(repository).build();
		items = shopInput.getRepository().findItemsBy();

	}

	@Test
	void itemsExists() {

		assertNotNull(items);

	}

	@Test
	void should_update_item() {
		Item item = GenericItem.builder().id(UUID.randomUUID().toString()).itemName("GenericItem").sellIn(5).quality(8).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(4, shopInput.getRepository().findItemsBy().get(0).getSellIn());
		assertEquals(7, shopInput.getRepository().findItemsBy().get(0).getQuality());
	}

	@Test
	void should_decrease_quality_twice_as_fast_after_sellin()  {
		Item item = GenericItem.builder().id(UUID.randomUUID().toString()).itemName("GenericItem").sellIn(0).quality(8).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(6, shopInput.getRepository().findItemsBy().get(0).getQuality());
	}

	@Test
	void should_not_decrease_quality_under_zero()  {
		Item item = GenericItem.builder().id(UUID.randomUUID().toString()).itemName("GenericItem").sellIn(5).quality(0).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(0, shopInput.getRepository().findItemsBy().get(0).getQuality());
	}

	@Test
	void should_increase_agedbrie_quality()  {
		Item item = AgingItem.builder().id(UUID.randomUUID().toString()).itemName("AgingItem").sellIn(5).quality(8).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(9, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
	}

 	@Test
	void should_not_increase_quality_over_fity()  {
		Item item = AgingItem.builder().id(UUID.randomUUID().toString()).itemName("AgingItem").sellIn(5).quality(50).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(50, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
	}

	@Test
	void should_not_changed_sulfuras_quality()  {
		Item item = LegendaryItem.builder().id(UUID.randomUUID().toString()).itemName("LegendaryItem").sellIn(5).quality(50).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(80, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
	}

	@Test
	void should_increase_event_item_quality()  {
		Item item = EventItem.builder().id(UUID.randomUUID().toString()).itemName("EventItem").sellIn(12).quality(8).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(9, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
		
	}

	@Test
	void should_increase_event_item_quality_ten_days_before()  {
		Item item = EventItem.builder().id(UUID.randomUUID().toString()).itemName("EventItem").sellIn(9).quality(33).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(35, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
	}

	@Test
	void should_increase_event_item_quality_five_days_before()  {
		Item item = EventItem.builder().id(UUID.randomUUID().toString()).itemName("EventItem").sellIn(4).quality(21).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(24, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
	}

	@Test
	void should_increase_event_item_quality_after_event()  {
		Item item = EventItem.builder().id(UUID.randomUUID().toString()).itemName("EventItem").sellIn(0).quality(21).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(0, shopInput.getRepository().findItemsBy().get(0).getQuality());
		
	}

	@Test
	void should_update_conjured_quality_twice_as_fast_as_generic()  {
		Item item = ConjuredItem.builder().id(UUID.randomUUID().toString()).itemName("ConjuredItem").sellIn(5).quality(8).basePrice(10).build();
		items.add(item);
		Item item1 = ConjuredItem.builder().id(UUID.randomUUID().toString()).itemName("ConjuredItem").sellIn(0).quality(8).basePrice(10).build();
		items.add(item1);
		Item item2 = ConjuredItem.builder().id(UUID.randomUUID().toString()).itemName("ConjuredItem").sellIn(0).quality(3).basePrice(10).build();
		items.add(item2);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();

		assertEquals(6, shopInput.getRepository().findItemsBy().get(0).getQuality());
		assertEquals(4, shopInput.getRepository().findItemsBy().get(1).getQuality());
		assertEquals(0, shopInput.getRepository().findItemsBy().get(2).getQuality());
		
	}

	@Test
	void should_get_item_value(){
		Item item = AgingItem.builder().id(UUID.randomUUID().toString()).itemName("AgingItem").sellIn(5).quality(50).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		shopInput.updateQuality();
		assertEquals(510, shopInput.getRepository().findItemsBy().get(0).getValue());
		
	}

    @Test
	void should_found_item_in_inventory(){
		Item item = AgingItem.builder().id(UUID.randomUUID().toString()).itemName("AgingItem").sellIn(5).quality(50).basePrice(10).build();
		items.add(item);

		shopInput.getRepository().saveInventory(items);
		String name = item.getItemName();
		int quality = item.getQuality();

		assertEquals(item, shopInput.getRepository().findItemByItemNameAndQuality(name, quality));
	}

	@Test
	void should_update_shop_solde_after_selling_item(){
		Item item = GenericItem.builder().id(UUID.randomUUID().toString()).itemName("GenericItem").sellIn(5).quality(8).basePrice(10).build();
		items.add(item);
		shopInput.getRepository().saveInventory(items);
		SellItemRequest request = new SellItemRequest(item.getItemName(), item.getQuality());
		shopInput.sellItem(request);
	     assertEquals(90,shopInput.getShopBalance());
	}

	@Test
	void should_warning_in_case_of_item_not_found() {
		Item item = GenericItem.builder().id(UUID.randomUUID().toString()).itemName("GenericItem").sellIn(5).quality(8).basePrice(10).build();
		items.add(item);
		shopInput.getRepository().saveInventory(items);
		SellItemRequest request = new SellItemRequest("test", 0);
	    shopInput.sellItem(request);
	}
}
