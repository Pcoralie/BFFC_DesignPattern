package Classes;

public class Aged_Brie extends Item {
    public Aged_Brie(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality()
    {
        //Quality of Aged Brie increases with time
        //However it must never be over 50
        if(this.getQuality()<50)
        {
            if (this.getSellIn() < 0) {
                this.setQuality(this.getQuality() + 2);
            }
            else
            {
                this.setQuality(this.getQuality() + 1);
            }
        }

        if(this.getQuality() > 50)
        {
            this.setQuality(50);
        }
    }
}
