package Classes;

public class Conjured_Cake extends Item{
    public Conjured_Cake(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality()
    {
        if(getQuality() < 50)
        {
            setQuality(getQuality() - 2);
        }
    }
}
