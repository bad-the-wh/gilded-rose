package gildedrose.core.domain.item;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class ConjuredItem extends Item {

    static String itemName = "Conjured";

    @Override
    public void update() {

        this.sellIn--;
        this.quality -= 2 ;

        if (this.sellIn <= 0){

            this.sellIn = 0;
            this.quality -= 2;

        }
        if (this.quality < 0){
            this.quality = 0;
        }
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }
}
