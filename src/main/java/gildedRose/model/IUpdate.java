package gildedRose.model;


import gildedRose.model.Item;

public interface IUpdate {
    void updateQuality(Item item);

    void incrementQuality( Item item);

    void decrementQuality(Item item);

    void updateSellIn(Item item);

    void updateOneItem(Item item);

}
