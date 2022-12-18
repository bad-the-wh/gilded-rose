package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@SuperBuilder
@Getter
@Setter
public class ShopInputBoundary extends ShopInteractor{

    private SellItemRequest sellItemRequest;

    private int shopBalance;

    public void updateInventory(Item item) {

        this.getRepository().updateInventory(item);
    }

    public void sellItem(SellItemRequest request) {

        Item item = this.getRepository().findItemByItemNameAndQuality(request.getType(),request.getQuality());
        int value = item.getValue();
        this.setShopBalance(this.getShopBalance()+value);
        this.getRepository().deleteItemByBasePrice(item.getId());
    }

}

