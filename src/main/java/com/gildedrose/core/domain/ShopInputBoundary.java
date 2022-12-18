package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;


public class ShopInputBoundary extends ShopInteractor{

    private SellItemRequest sellItemRequest;

    private int shopBalance;

    ItemsGateway itemsGateway;

    public void updateInventory(Item item) {

        this.getRepository().updateInventory(item);
    }

    public void sellItem(SellItemRequest request) {

        Item item = this.getRepository().findItemByItemNameAndQuality(request.getType(),request.getQuality());
        int value = item.getValue();
        this.setBalance(this.getBalance()+value);
        itemsGateway.deleteItemByBasePrice(item.getId());
    }

}

