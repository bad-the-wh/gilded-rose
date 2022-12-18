package com.gildedrose.core.domain;

import com.gildedrose.core.domain.item.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsGateway extends JpaRepository<Item, String>, ItemsGatewayCustom {

    List<Item> findItemsBy();

    Item findItemByItemNameAndQuality(String type, int quality) ;

}


