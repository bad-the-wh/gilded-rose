package com.gildedrose.core.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue("ConjuredItem")
public class ConjuredItem extends Item {

    static String itemName = "ConjuredItem";

    @Override
    public void update() {

        this.sellIn--;
        this.quality -= 2 ;

        if (this.sellIn <= 0){

            this.sellIn = 0;
            this.quality -= 2;

        }
        if (this.quality < 0){
            this.quality = 0;
        }
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }
}
