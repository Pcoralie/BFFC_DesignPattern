package Classes;

import Interface.IUpdate;

public  class Item implements IUpdate{

    protected String name;
    protected int sellIn;

    protected int quality;

    public Item(String name, int sellIn, int quality) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }


    public void incrementQuality( Item item){
        if (item.quality <50){
            item.quality = item.quality + 1;
        }
    }

    public void decrementQuality(Item item){
        if (item.quality > 0){
            item.quality = item.quality - 1;
        }
    }

    public void updateExpired(Item item){
        decrementQuality(item);
    }

    public void updateSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }

    public void updateQuality(Item item){
        decrementQuality(item);
    }

    public void updateOneItem(Item item){
        updateQuality(item);

        updateSellIn(item);

        if(item.sellIn < 0){
            updateExpired(item);
        }
    }

    /*
     public void update(Aged_Brie aged_brie)
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
    public void update(Backstage_passes backstage_passes)
    {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
            if (getSellIn() < 11) {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
            if (getSellIn() < 6) {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }

    public void update(Conjured_Cake conjured_cake)
    {
        if(getQuality() < 50)
        {
            setQuality(getQuality() - 2);
        }
    }

    public void update(Dexterity dexterity)
    {

    }

    public void update(Elixir elixir)
    {

    }

    public void update(Sulfuras sulfuras)
    {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
       }
     */



    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
}