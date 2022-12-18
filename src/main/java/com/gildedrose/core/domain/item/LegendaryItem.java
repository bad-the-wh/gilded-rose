package com.gildedrose.core.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@Entity
@DiscriminatorValue("LegendaryItem")
public class LegendaryItem extends Item {

    @Override
    public void update() {
        sellIn = 0;
        quality = 80;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }

    public LegendaryItem(){

        this.sellIn = 0;
        this.quality = 80;

    }
}
