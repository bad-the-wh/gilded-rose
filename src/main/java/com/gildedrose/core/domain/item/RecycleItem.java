package com.gildedrose.core.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.gildedrose.core.domain.ShopInputBoundary;

import java.lang.annotation.Inherited;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue("RecycleItem")
public class RecycleItem extends Item {

    public void update() {
        this.sellIn--;
        this.quality--;

        if (this.sellIn < 0){
            this.sellIn = 0;
            this.quality--;
        }


        if (this.quality < 0)
            this.quality = 0;
    }

    @Override
    public int getValue(){

        return 0 ; 
    }


}

