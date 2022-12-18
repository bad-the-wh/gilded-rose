package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@SuperBuilder
@Getter
@Setter
public class ShopOutputBoundary extends ShopInteractor  {

    public void DisplayInventory() {

        List<Item> items = this.getRepository().findItemsBy();
        System.out.print(items);

    }

    public void DisplayBalance(int balance){

        System.out.print("Current shop balance is " + balance + ". \n");

    }

}