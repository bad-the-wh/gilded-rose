package gildedrose;

import java.util.ArrayList;

public class Shop {

    public ArrayList<Item> items;

    public Shop(ArrayList<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {

          }
        }
    };

        /*for (int i = 0; i < items.length; i++){
            if(!items[i].getItemName().equals("Aged Brie")
                && !items[i].getItemName().equals("Backstage Passes")){
                if (items[i].getQuality() > 0) {
                    if (!items[i].getItemName().equals("Sulfuras")) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
            }
                else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);

                        if (items[i].getItemName().equals("Backstage Passes")) {
                            if (items[i].getSellIn() < 11) {
                                if (items[i].getQuality() < 50) {
                                    items[i].setQuality(items[i].getQuality() + 1);
                                }
                            }

                            if (items[i].getSellIn() < 6) {
                                if (items[i].getQuality() < 50) {
                                    items[i].getQuality(items[i].getQuality() + 1);
                                }
                            }
                        }
                    }
                }

                if (!items[i].getItemName().equals("Sulfuras")) {
                    items[i].setSellIn(items[i].getSellIn() - 1);
                }

                if (items[i].getSellIn() < 0) {
                    if (!items[i].getItemName().equals("Aged Brie")) {
                        if (!items[i].getItemName().equals("Backstage Passes")) {
                            if (items[i].getQuality() > 0) {
                                if (!items[i].getItemName().equals("Sulfuras")) {
                                    items[i].setQuality(items[i].getQuality() - 1);
                                }
                            }
                        } else {
                            items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                        }
                    }
                    else {
                        if (items[i].getQuality() < 50) {
                            items[i].setQuality(items[i].getQuality() + 1);
                        }
                    }
                }
            }
        }*/
