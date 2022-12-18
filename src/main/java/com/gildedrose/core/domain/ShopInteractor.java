package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Service
public class ShopInteractor {

    private ItemsGateway repository;
    private int balance;

    public void updateQuality() {
        List<Item> items = repository.findItemsBy();
        for (Item item : items) {
            item.update();
            repository.updateInventory(item);
        }
    }

    public int getBalance(){
        return this.balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }
}
