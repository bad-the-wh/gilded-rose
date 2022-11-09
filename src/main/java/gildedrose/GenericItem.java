package gildedrose;

public class GenericItem extends Item{

    public GenericItem(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;
        this.quality--;

        if (this.sellIn < 0)
            this.quality--;
        
        if (this.quality < 0)
            this.quality = 0;
    }
}

