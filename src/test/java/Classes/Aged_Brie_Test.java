package Classes;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Aged_Brie_Test {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemAgedBrie = items[1];

        assertThat(itemAgedBrie.getName(), is ("Aged Brie"));
        assertThat(itemAgedBrie.getQuality() , is(0));
        itemAgedBrie.updateQuality();
        assertThat(itemAgedBrie.getQuality(), is(1));
    }

    @Test
    public void qualityCheckBis()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemAgedBrie = items[6];

        assertThat(itemAgedBrie.getName(), is ("Aged Brie"));
        assertThat(itemAgedBrie.getSellIn(), is(-2));
        assertThat(itemAgedBrie.getQuality() , is(3));
        itemAgedBrie.updateQuality();
        assertThat(itemAgedBrie.getQuality(), is(5));
    }


}
