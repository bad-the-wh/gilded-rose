package gildedrose.core.domain;

import gildedrose.core.domain.item.Item;

import java.io.FileNotFoundException;

public class ShopInputBoundary extends ShopInteractor{

    private SellIitemRequest sellIitemRequest;

    public void updateInventory(Item item) throws FileNotFoundException {

        this.getRepository().updateInventory(item);
    }

    public void sellItem(SellIitemRequest request) throws FileNotFoundException {

        Item item = this.getRepository().findItem(request.getType(),request.getQuality());
        updateInventory(item);

    }

}
