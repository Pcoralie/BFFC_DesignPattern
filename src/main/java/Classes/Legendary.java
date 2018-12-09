package Classes;

public class Legendary extends Item {
    public Legendary(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Legendary() {
    }

    public void updateQuality()
    {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }

    public void updateExpired(Item item){
    }

    public void updateSellIn(Item item){

    }

    public void updateQuality(Item item){
    }
}