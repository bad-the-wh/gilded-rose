package com.gildedrose.controller;

import com.gildedrose.core.domain.ShopInputBoundary;
import com.gildedrose.core.domain.ShopOutputBoundary;
import com.gildedrose.core.domain.item.GenericItem;
import com.gildedrose.core.domain.item.Item;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ResponseBody
public class GildedRoseController {

    private ShopInputBoundary shopInputBoundary;

    private ShopOutputBoundary shopOutputBoundary;

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Index");
        return modelAndView;
    }

    @RequestMapping("/")
    public void showShopBalance(){

        shopOutputBoundary.DisplayBalance(shopInputBoundary.getShopBalance());

    }

    @RequestMapping("/displayShop")
    public void displayShop(){

        shopOutputBoundary.DisplayInventory();

    }


}

