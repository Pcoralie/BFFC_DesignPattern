package Classes;

public class BackstagePass extends Item {


    public BackstagePass(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public BackstagePass() {
    }


    public void updateQuality()
    {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);

            if (getSellIn() < 10) {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }

            if (getSellIn() < 5) {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }


    public void updateExpired(Item item){
        item.quality = 0;
    }

    public void updateQuality(Item item){
        incrementQuality(item);

        if (item.sellIn <= 10){
            incrementQuality(item);
        }

        if (item.sellIn <= 5){
            incrementQuality(item);
        }
    }
}
