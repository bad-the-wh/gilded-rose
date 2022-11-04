package gildedrose;

public class Item {

    private String itemName;
    private int sellIn;
    private int quality;

    public Item (int sellIn, int quality){

        // this.itemName = itemName;
        this.sellIn = sellIn;
        this.quality = quality;

    }

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
