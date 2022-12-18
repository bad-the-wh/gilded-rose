package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemsGatewayCustom {

    @Transactional
    void saveInventory(List<Item> items);

    @Transactional
    void updateInventory(Item item) ;

}
