package gildedrose.CoreDomain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegendaryItem extends Item {

    static String itemName = "Sulfura";

    @Override
    public void update() {
        sellIn = 0;
        quality = 80;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }

    public LegendaryItem(){

        this.sellIn = 0;
        this.quality = 80;

    }
}
