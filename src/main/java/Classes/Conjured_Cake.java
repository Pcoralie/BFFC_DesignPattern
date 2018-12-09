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
        if(this.getQuality() >0 )
        {
            if (this.getSellIn() < 0) {
                this.setQuality(this.getQuality() - 4);
            }
            else {
                this.setQuality((this.getQuality() - 2));
            }
        }

        if(this.getQuality()<0)
        {
            this.setQuality(0);
        }

    }
}
