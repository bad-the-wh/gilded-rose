package gildedrose.core.domain.item;

import gildedrose.core.domain.item.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class GenericItem extends Item {

    static String itemName = "Generic";

    @Override
    public void update() {
        this.sellIn--;
        this.quality--;

        if (this.sellIn < 0){
            this.sellIn = 0;
            this.quality--;
        }


        if (this.quality < 0)
            this.quality = 0;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }
}

