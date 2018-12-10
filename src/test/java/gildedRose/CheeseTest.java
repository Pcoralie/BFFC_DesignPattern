package gildedRose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheeseTest {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemCheese = items[1];

        assertThat(itemCheese.getName(), is ("Aged Brie"));
        assertThat(itemCheese.getQuality() , is(0));
        inventory.updateQuality();
        assertThat(items[1].getQuality(), is(1));
    }

    @Test
    public void qualityCheckSellinNegative()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemCheese = items[7];

        assertThat(itemCheese.getName(), is ("Aged Camembert"));
        assertThat(itemCheese.getSellIn(), is(-2));
        assertThat(itemCheese.getQuality() , is(5));
        inventory.updateQuality();
        assertThat(items[7].getQuality(), is(7));
    }

}
