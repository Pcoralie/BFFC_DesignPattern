package Classes;

public class Backstage_passes extends Item {
    public Backstage_passes(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality()
    {
        if(this.getSellIn() <0)
        {
            this.setQuality(0);
        }
        else
        {
            if(this.getQuality() < 50)
            {
                if(this.getSellIn() <= 10)
                {
                    if(this.getSellIn() <= 5)
                    {
                        this.setQuality(this.getQuality() + 3);
                    }
                    else
                    {
                        this.setQuality(this.getQuality() + 2);
                    }
                }
                else
                {
                    this.setQuality(this.getQuality() + 1);
                }
            }
        }

        if(this.getQuality() > 50)
        {
            this.setQuality(50);
        }

    }
}
