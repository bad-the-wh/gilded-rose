package gildedrose;

public class EventItem extends Item{

    public EventItem(int sellIn, int quality) {

        super(sellIn, quality);

    }

    @Override
    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.sellIn < 10)
            this.quality++;
        if (this.sellIn < 5)
            this.quality++;
        if (this.sellIn < 0)
            this.quality = 0;
 
        if (this.quality > 50)
            this.quality = 50;
    }
}
