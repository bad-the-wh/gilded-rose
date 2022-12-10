package gildedrose.core.domain;

import gildedrose.core.domain.item.Item;
import lombok.*;

import java.io.FileNotFoundException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ShopInteractor {

    private ItemsGateway repository;

    public void updateQuality() throws FileNotFoundException {
        List<Item> items = repository.getInventory();
        for (Item item : items) {
            item.update();
        }
        this.repository.saveInventory(items);
    }


}
