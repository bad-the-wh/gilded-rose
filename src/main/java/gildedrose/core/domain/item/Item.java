package gildedrose.core.domain.item;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
public abstract class Item {

    String itemName;
    int sellIn;
    int quality;
    int basePrice;

    public abstract void update();

    public abstract int getValue();

    public String getItemName() {
        return itemName;
    }

    public void setSellin(int int1) {
    }
}
