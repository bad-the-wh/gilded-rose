package gildedrose.CoreDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class EventItem extends Item {

    static final String itemName = "Backstage Pass";

    @Override
    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.sellIn < 10)
            this.quality++;

        if (this.sellIn < 5)
            this.quality++;

        if (this.sellIn <= 0){
            this.quality = 0;
            this.sellIn = 0;
        }

        if (this.quality > 50)
            this.quality = 50;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }
}
