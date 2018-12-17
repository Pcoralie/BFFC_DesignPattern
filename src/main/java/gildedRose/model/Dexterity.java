package gildedRose.model;

import java.util.Calendar;

public class Dexterity extends Item {
    public Dexterity(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Dexterity(String name, int sellIn, int quality, Calendar calendar)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.creationDate = calendar;
    }

    public void updateQuality()
    {

    }
}
