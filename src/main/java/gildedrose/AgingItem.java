package gildedrose;

public class AgingItem extends Item {

    public AgingItem(int sellIn, int quality) {

        super(sellIn, quality);

    }

    @Override
    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.quality > 50)
            this.quality = 50;
    }
}
