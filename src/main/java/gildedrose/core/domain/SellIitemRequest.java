package gildedrose.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SellIitemRequest {

    private String type;

    private int quality;

}
