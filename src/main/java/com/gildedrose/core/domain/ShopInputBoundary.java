package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;


public class ShopInputBoundary extends ShopInteractor{

    private SellItemRequest sellItemRequest;

    public void updateInventory(Item item) {

        this.getRepository().updateInventory(item);
    }

    public void sellItem(SellItemRequest request) {

        Item item = this.getRepository().findItemByItemNameAndQuality(request.getType(),request.getQuality());
        int value = item.getValue();
        this.setBalance(this.getBalance()+value);
        this.getRepository().delete(item);

    }

}

