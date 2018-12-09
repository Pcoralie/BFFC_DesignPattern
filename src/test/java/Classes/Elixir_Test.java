package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Elixir_Test {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemElixir = items[2];

        assertThat(itemElixir.getName(), is ("Elixir of the Mongoose"));
        assertThat(itemElixir.getQuality() , is(7));
        itemElixir.updateQuality();
        assertThat(itemElixir.getQuality(), is(6));
    }

    @Test
    public void qualityCheckBis()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemElixir = items[9];

        assertThat(itemElixir.getName(), is ("Elixir of the Mongoose"));
        assertThat(itemElixir.getSellIn(), is(-2));
        assertThat(itemElixir.getQuality() , is(7));
        itemElixir.updateQuality();
        assertThat(itemElixir.getQuality(), is(5));
    }
}
