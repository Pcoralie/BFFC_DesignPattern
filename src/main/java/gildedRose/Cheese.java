package gildedRose;

public class Cheese extends Item {
    public Cheese(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Cheese() {
    }

    public void updateQuality()
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

    public void updateExpired(Item item){
        incrementQuality(item);
    }

    public void updateQuality(Item item){
        incrementQuality(item);
    }
}
