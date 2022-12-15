package gildedrose;

import gildedrose.core.domain.ShopInteractor;
import gildedrose.core.domain.item.*;
import gildedrose.persistance.DbItemsGateway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GildedRoseTest {
    DbItemsGateway repository ;
    ShopInteractor shop;
    Item itemNeeded = GenericItem.builder().sellIn(0).quality(8).build();
    List<Item> items;

    @BeforeEach
    void setup() throws FileNotFoundException {

        repository = new DbItemsGateway();
     
        shop = new ShopInteractor(repository);
        shop.updateQuality();
         

   }

   @Test
   void should_update_item()  {
       assertEquals(4, repository.getInventory().get(0).getSellIn());
       assertEquals(7, repository.getInventory().get(0).getQuality());
   }

   @Test
   void should_decrease_quality_twice_as_fast_after_sellin()  {
       assertEquals(6, repository.getInventory().get(1).getQuality());
   }

   @Test
   void should_not_decrease_quality_under_zero()  {
       assertEquals(0, repository.getInventory().get(2).getQuality());
   }

   @Test
   void should_increase_agedbrie_quality()  {
       assertEquals(9, repository.getInventory().get(3).getQuality());
   }

   @Test
   void should_not_increase_quality_over_fity()  {
       assertEquals(50, repository.getInventory().get(4).getQuality());
   }

   @Test
   void should_not_changed_sulfuras_quality()  {
       assertEquals(80, repository.getInventory().get(5).getQuality());
   }

   @Test
   void should_increase_event_item_quality()  {
       assertEquals(9, repository.getInventory().get(6).getQuality());
       assertEquals(50, repository.getInventory().get(7).getQuality());
   }

   @Test
   void should_increase_event_item_quality_ten_days_before()  {
       assertEquals(35, repository.getInventory().get(8).getQuality());
   }

   @Test
   void should_increase_event_item_quality_five_days_before()  {
       assertEquals(24, repository.getInventory().get(9).getQuality());
   }

   @Test
   void should_increase_event_item_quality_after_event()  {
       assertEquals(0, repository.getInventory().get(10).getQuality());
   }

   @Test
   void should_update_conjured_quality_twice_as_fast_as_generic()  {
       assertEquals(6, repository.getInventory().get(11).getQuality());
       assertEquals(4, repository.getInventory().get(12).getQuality());
       assertEquals(0, repository.getInventory().get(13).getQuality());
   }

   @Test  
   void should_get_item_value(){
       assertEquals(510,repository.getInventory().get(4).getValue() );
   }

   @Test
   void should_found_item_in_inventory(){
        assertEquals(itemNeeded.getClass(),repository.findItem("GenericItem", 7).getClass());
       
   }

   //@Test
   //void should_update_shop_solde_after_selling_item(){
   //     assertEquals(80,shop.sellItem("GenericItem",7));
      
   //}

   //@Test
   //void should_warning_in_case_of_item_not_found() throws ItemNotFoundException {
   //    shop.sellItem("test", 0);
   //}             

}