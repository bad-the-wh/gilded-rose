package gildedrose;

public class AgingItem extends Item {

    public AgingItem(int sellIn, int quality) {

        super(sellIn, quality);

    }

    @Override
    public void update(){
        if (this.getSellIn() != 0 ){
            this.setSellIn(this.getSellIn()-1);
            if (this.getQuality() < 50) {
                this.setQuality(this.getQuality() + 1);
            }
        }
    }
}
