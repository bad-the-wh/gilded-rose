package gildedrose;

public abstract class Item {

    protected String itemName;
    protected int sellIn;
    protected int quality;

    public Item (Integer sellIn, int quality){

        this.sellIn = sellIn;
        this.quality = quality;

    };

    public Item (String itemName, Integer sellIn, int quality){

        this.itemName = itemName;
        this.sellIn = sellIn;
        this.quality = quality;

    }

    public abstract void update();

    public String getItemName() {
        return itemName;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
}
