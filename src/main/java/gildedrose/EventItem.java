package gildedrose;

import javax.lang.model.util.ElementScanner14;

public class EventItem extends Item{

    public EventItem(int sellIn, int quality) {

        super(sellIn, quality);

    }

    @Override
    public void update() {
        if (this.getSellIn() > 10 ) {
            this.setSellIn(this.getSellIn()-1);
            if (this.getQuality() < 50) {
                this.setQuality(this.getQuality() + 1);
            }
        }
        else {
            if (this.getSellIn() == 0 ){
                this.setQuality(0);
            }
            else {
                this.setQuality(this.getQuality() + 2);
                this.setSellIn(this.getSellIn()-1);
            }
        }
    }
}
