package Classes;

import edu.insightr.gildedrose.Interface.IUpdate;

public abstract class Item implements IUpdate{

    protected String name;
    protected int sellIn;

    protected int quality;

    /*public Item(String name, int sellIn, int quality) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }*/

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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
}