package com.gildedrose.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SellItemRequest {

    private String type;

    private int quality;

}