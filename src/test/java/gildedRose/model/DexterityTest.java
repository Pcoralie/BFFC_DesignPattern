package gildedRose.model;

import gildedRose.model.Inventory;
import gildedRose.model.Item;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DexterityTest {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemDexterity = items[0];

        assertThat(itemDexterity.getName(), is ("+5 Dexterity Vest"));
        assertThat(itemDexterity.getQuality() , is(20));
        inventory.updateQuality();
        assertThat(items[0].getQuality(), is(19));
    }

    @Test
    public void qualityCheckSellinNegative()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemDexterity = items[6];

        assertThat(itemDexterity.getName(), is ("+6 Dexterity Pants"));
        assertThat(itemDexterity.getSellIn(), is (-2));
        assertThat(itemDexterity.getQuality() , is(20));
        inventory.updateQuality();
        assertThat(items[6].getQuality(), is(18));
    }
}
