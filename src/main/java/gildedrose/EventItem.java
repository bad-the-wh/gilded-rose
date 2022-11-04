package gildedrose;

public class EventItem extends Item{

    public EventItem(int sellIn, int quality) {

        super(sellIn, quality);

    }

    @Override
    public void update() {
        if (this.getSellIn() == 0 ){
            this.setQuality(0);
        }
        else {
        if (this.getSellIn()<6){
            this.setSellIn(this.getSellIn()-1);
            if (this.getQuality() > 46 ) {
                this.setQuality(50);
            }
            else{
                this.setQuality(this.getQuality()+3);
            }
        }
        else {
            if (this.getSellIn() < 11 ) {
                if (this.getQuality() > 47) {
                this.setQuality(50);
                }
                else {
                this.setQuality(this.getQuality()+2);
                }
                this.setSellIn(this.getSellIn()-1);
            }
            else {
                if (this.getQuality() > 48) {
                    this.setQuality(50);
                    }
                else {
                this.setQuality(this.getQuality() + 1);
                }
                this.setSellIn(this.getSellIn()-1);
            }
        }
    }
}
}
