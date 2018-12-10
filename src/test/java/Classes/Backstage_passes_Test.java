package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Backstage_passes_Test {
    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemBackstage = items[4];

        assertThat(itemBackstage.getName(), is ("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(itemBackstage.getQuality() , is(20));
        itemBackstage.updateQuality();
        assertThat(itemBackstage.getQuality(), is(21));
    }

    @Test
    public void qualityCheckBis()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemBackstage = items[10];

        assertThat(itemBackstage.getName(), is ("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(itemBackstage.getSellIn(), is(8));
        assertThat(itemBackstage.getQuality() , is(45));
        itemBackstage.updateQuality();
        assertThat(itemBackstage.getQuality(), is(47));
    }

    @Test
    public void qualityCheckTer()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemBackstage = items[11];

        assertThat(itemBackstage.getName(), is ("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(itemBackstage.getSellIn(), is(3));
        assertThat(itemBackstage.getQuality() , is(20));
        itemBackstage.updateQuality();
        assertThat(itemBackstage.getQuality(), is(23));
    }
}
