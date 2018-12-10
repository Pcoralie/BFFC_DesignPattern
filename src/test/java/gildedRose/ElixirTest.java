package gildedRose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ElixirTest {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemElixir = items[2];

        assertThat(itemElixir.getName(), is ("Elixir of the Mongoose"));
        assertThat(itemElixir.getQuality() , is(7));
        inventory.updateQuality();
        assertThat(items[2].getQuality(), is(6));
    }

    @Test
    public void qualityCheckSellinNegative()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemElixir = items[8];

        assertThat(itemElixir.getName(), is ("Elixir of the Elders"));
        assertThat(itemElixir.getSellIn(), is (-2));
        assertThat(itemElixir.getQuality() , is(7));
        inventory.updateQuality();
        assertThat(items[8].getQuality(), is(5));
    }
}
