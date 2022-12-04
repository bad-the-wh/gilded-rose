package gildedrose;

public interface ShopInputBoudary {

    public default void updateInventory(){}

    public default void sellItem(SellItemRequest request){}


}
