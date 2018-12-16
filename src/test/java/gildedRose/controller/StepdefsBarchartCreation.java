package gildedRose.controller;

import gildedRose.model.Inventory;
import gildedRose.model.Item;

public class StepdefsBarchartCreation {

    private ShopView shopview = new ShopView();
    private Inventory inventory = this.shopview.getGlobalInventory();
    private Item[] items = inventory.getItems();

}
