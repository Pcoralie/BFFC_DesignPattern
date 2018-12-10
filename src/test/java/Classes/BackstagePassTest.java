package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BackstagePassTest {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemBackstage = items[4];

        assertThat(itemBackstage.getName(), is ("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(itemBackstage.getQuality() , is(20));
        inventory.updateQuality();
        assertThat(items[4].getQuality(), is(21));
    }

    @Test
    public void qualityCheckSellinUnder10()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemBackstage = items[9];

        assertThat(itemBackstage.getName(), is ("Backstage passes to a TAFKAL80ETC concert 2"));
        assertThat(itemBackstage.getSellIn(), is(8));
        assertThat(itemBackstage.getQuality() , is(20));
        inventory.updateQuality();
        assertThat(items[9].getQuality(), is(22));
    }

    @Test
    public void qualityCheckSellinUnder5()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemBackstage = items[10];

        assertThat(itemBackstage.getName(), is ("Backstage passes to a TAFKAL80ETC concert 3"));
        assertThat(itemBackstage.getSellIn(), is(3));
        assertThat(itemBackstage.getQuality() , is(20));
        inventory.updateQuality();
        assertThat(items[10].getQuality(), is(23));
    }
}
