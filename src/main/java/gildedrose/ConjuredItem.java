package gildedrose;

public class ConjuredItem extends Item{

    public ConjuredItem(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;
        this.quality=this.quality - 2 ;

        if (this.sellIn < 0)
            this.quality= this.quality - 2;
        
        if (this.quality < 0)
            this.quality = 0;
    }
}
