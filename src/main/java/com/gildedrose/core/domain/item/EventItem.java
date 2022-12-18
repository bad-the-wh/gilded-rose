package com.gildedrose.core.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("EventItem")
public class EventItem extends Item {

    @Override
    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.sellIn < 10)
            this.quality++;

        if (this.sellIn < 5)
            this.quality++;

        if (this.sellIn <= 0){
            this.quality = 0;
            this.sellIn = 0;
        }

        if (this.quality > 50)
            this.quality = 50;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }
}
