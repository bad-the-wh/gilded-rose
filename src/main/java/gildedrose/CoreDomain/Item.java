package gildedrose.CoreDomain;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
public abstract class Item {

    static String itemName;
    int sellIn;
    int quality;
    int basePrice;

    public abstract void update();

    public abstract int getValue();

    public String getItemName() {
        return itemName;
    }
}
