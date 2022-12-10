package gildedrose.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemResponse {

    private int sellIn;

    private int quality;

    private int value;

}
