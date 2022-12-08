package gildedrose.Vue;

import gildedrose.CoreDomain.Item;
import gildedrose.CoreDomain.Shop;

import java.io.FileNotFoundException;
import java.util.List;

public class ShopView {

    private Shop shop;
    private int balance;

    public void DisplayInventory() throws FileNotFoundException {

        List<Item> items = shop.getRepository().getInventory();
        System.out.print(items);

    }

    public void DisplayBalance(){

        System.out.print(balance);

    }

    public void UpdateInventory(Item item) throws FileNotFoundException {

        shop.updateInventory(item);

    }

    public void sellItem(String type, int quality) throws FileNotFoundException {

        shop.sellItem(type, quality);

    }

    public static void main(String[] args) {}

}
