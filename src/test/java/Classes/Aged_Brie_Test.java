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
        assertThat(itemAgedBrie.getQuality() , is(6));
        itemAgedBrie.updateQuality();
        assertThat(itemAgedBrie.getQuality(), is(7));
    }


}
