package gildedRose.model;

public class Conjured extends Item{
    public Conjured(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Conjured() {
    }

    public void updateQuality()
    {
        if(getQuality() < 50)
        {
            setQuality(getQuality() - 2);
        }
    }

    public void updateExpired(Item item){
        decrementQuality(item);
        decrementQuality(item);
    }

    public void updateQuality(Item item){
        decrementQuality(item);
        decrementQuality(item);
    }
}
