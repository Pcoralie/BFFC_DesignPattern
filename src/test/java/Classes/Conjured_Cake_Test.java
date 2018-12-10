package Classes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Conjured_Cake_Test {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemConjured = items[5];

        assertThat(itemConjured.getName(), is ("Conjured Mana Cake"));
        assertThat(itemConjured.getQuality() , is(6));
        itemConjured.updateQuality();
        assertThat(itemConjured.getQuality(), is(4));
    }

    @Test
    public void qualityCheckBis()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemConjured = items[7];

        assertThat(itemConjured.getName(), is ("Conjured Mana Cake"));
        assertThat(itemConjured.getSellIn(), is(-2));
        assertThat(itemConjured.getQuality() , is(6));
        itemConjured.updateQuality();
        assertThat(itemConjured.getQuality(), is(2));
    }
}
