package gildedrose.core.domain;

import gildedrose.core.domain.item.Item;

import java.io.FileNotFoundException;
import java.util.List;

public class ShopOutputBoundary extends ShopInteractor  {

    public void DisplayInventory() throws FileNotFoundException {

        List<Item> items = this.getRepository().getInventory();
        System.out.print(items);

    }

    public void DisplayBalance(int balance){

        System.out.print("Current shop balance is " + balance + ". \n");

    }

}
