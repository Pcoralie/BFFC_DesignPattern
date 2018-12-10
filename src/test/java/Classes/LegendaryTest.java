package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LegendaryTest {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemLegendary = items[3];

        assertThat(itemLegendary.getName(), is ("Legendary, Hand of Ragnaros"));
        assertThat(itemLegendary.getQuality() , is(80));
        inventory.updateQuality();
        assertThat(items[3].getQuality(), is(80));
    }
}
