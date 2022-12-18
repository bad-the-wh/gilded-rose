package com.gildedrose.core.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.gildedrose.core.domain.item.*;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("AgingItem")
public class AgingItem extends Item {

    @Override
    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.sellIn < 0){

            this.sellIn = 0;
            this.quality--;

        }


        if (this.quality > 50)
            this.quality = 50;
    }

    @Override
    public int getValue(){

        return basePrice + (quality * 10);

    }

}
