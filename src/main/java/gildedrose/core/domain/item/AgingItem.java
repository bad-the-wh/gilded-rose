package gildedrose.core.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class AgingItem extends Item {

    static String itemName = "Aged Brie";

    @Override
    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.sellIn < 0){

            this.sellIn = 0;
            this.quality--;

        }


        if (this.quality > 50)
            this.quality = 50;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }

}
