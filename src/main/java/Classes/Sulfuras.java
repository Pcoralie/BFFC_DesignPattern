package Classes;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality()
    {
        //We don't need to do anything since Sulfuras is a legendary item.
    }
}
