package gildedrose;

public class GenericItem extends Item{

    public GenericItem(int sellIn, int quality) {

        super(sellIn, quality);

    }


    @Override
    public void update(){

        if(this.getSellIn() > 0){

            if(this.getQuality() >0){

                this.setSellIn(this.getSellIn() - 1);
                this.setQuality(this.getQuality() - 1);

            }

        }

        else {

            if(this.getQuality() > 1){

                this.setQuality(this.getQuality() - 2);

            }

            else{

                this.setQuality(0);

            }

        }


    }

}

