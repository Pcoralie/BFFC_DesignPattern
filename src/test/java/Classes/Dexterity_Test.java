package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Dexterity_Test {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemDexterity = items[0];

        assertThat(itemDexterity.getName(), is ("+5 Dexterity Vest"));
        assertThat(itemDexterity.getQuality() , is(20));
        itemDexterity.updateQuality();
        assertThat(itemDexterity.getQuality(), is(19));
    }

    @Test
    public void qualityCheckBis()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemDexterity = items[8];

        assertThat(itemDexterity.getName(), is ("+5 Dexterity Vest"));
        assertThat(itemDexterity.getSellIn(), is(-2));
        assertThat(itemDexterity.getQuality() , is(20));
        itemDexterity.updateQuality();
        assertThat(itemDexterity.getQuality(), is(18));
    }
}
