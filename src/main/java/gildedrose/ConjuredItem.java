package gildedrose;

public class ConjuredItem extends Item{

    public ConjuredItem(int sellIn, int quality) {

        super(sellIn, quality);

    }

    @Override
    public void update() {

        if(this.getSellIn() > 0){

            if(this.getQuality() >1){

                this.setSellIn(this.getSellIn() - 1);
                this.setQuality(this.getQuality() - 2);

            }

            else{

                this.setSellIn(this.getSellIn() - 1);
                this.setQuality(0);
            }

        }

        else {

            if(this.getQuality() > 3){

                this.setQuality(this.getQuality() - 4);

            }

            else{

                this.setQuality(0);

            }

        }


    }
}
