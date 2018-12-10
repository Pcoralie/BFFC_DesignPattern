package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Sulfuras_Test {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemSulfura = items[3];

        assertThat(itemSulfura.getName(), is ("Sulfuras, Hand of Ragnaros"));
        assertThat(itemSulfura.getQuality() , is(80));
        itemSulfura.updateQuality();
        assertThat(itemSulfura.getQuality(), is(80));
    }
}
