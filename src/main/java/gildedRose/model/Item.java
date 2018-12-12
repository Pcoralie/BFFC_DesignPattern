package gildedRose.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Item implements IUpdate {

    protected String name;
    protected int sellIn;
    protected int quality;
    protected Calendar creationDate;

    public Item(String name, int sellIn, int quality) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    
    public Item() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    /*
    public void update(Cheese aged_brie)
    {
        if (this.getQuality() < 50) {
            this.setQuality(this.getQuality() + 1);
        }

        if (this.getSellIn() < 0) {
            if (this.getQuality() < 50) {
                this.setQuality(this.getQuality() + 1);
            }
        }
    }

    public void update(BackstagePass backstage_passes)
    {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);

            if (getSellIn() < 11) {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }

            if (getSellIn() < 6) {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }

    public void update(Conjured conjured_cake)
    {
        if(getQuality() < 50)
        {
            setQuality(getQuality() - 2);
        }
    }

    public void update(Dexterity dexterity)
    {

    }

    public void update(Elixir elixir)
    {

    }

    public void update(Legendary sulfuras)
    {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }*/

    public void incrementQuality( Item item){
        if (item.quality <50){
            item.quality = item.quality + 1;
        }
    }

    public void decrementQuality(Item item){
        if (item.quality > 0){
            item.quality = item.quality - 1;
        }
    }

    public void updateExpired(Item item){
        decrementQuality(item);
    }

    public void updateSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }

    public void updateQuality(Item item){
        decrementQuality(item);
    }

    public void updateOneItem(Item item){
        updateQuality(item);

        updateSellIn(item);

        if(item.sellIn < 0){
            updateExpired(item);
        }
    }

    
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return name +
                ", sellIn : " + sellIn +
                ", quality : " + quality + ", creation Date : " + " " + sdf.format(creationDate.getTime());
    }
}
