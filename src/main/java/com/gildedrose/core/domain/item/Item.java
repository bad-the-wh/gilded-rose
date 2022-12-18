package com.gildedrose.core.domain.item;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="NAME")
@Table(name = "ITEMS")
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String id;

    @Column(name = "NAME",length = 50, nullable = false, insertable=false, updatable=false)
    String itemName;

    @Column(name = "SELLIN", nullable = false, insertable=false, updatable=false)
    int sellIn;

    @Column(name = "QUALITY", nullable = false, insertable=false, updatable=false)
    int quality;

    @Column(name = "BASE_PRICE", nullable = false, insertable=false, updatable=false)
    int basePrice;

    public abstract void update();

    public abstract int getValue();

    public String getItemName() {
        return itemName;
    }

}
