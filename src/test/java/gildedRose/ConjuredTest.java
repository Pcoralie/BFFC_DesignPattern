package gildedRose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConjuredTest {

    @Test
    public void qualityCheck()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemConjured = items[5];

        assertThat(itemConjured.getName(), is ("Conjured Mana Cake"));
        assertThat(itemConjured.getQuality() , is(6));
        inventory.updateQuality();
        assertThat(items[5].getQuality(), is(4));
    }

    @Test
    public void qualityCheckSellinNegative()
    {
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();

        Item itemConjured = items[11];

        assertThat(itemConjured.getName(), is ("Conjured Health Cake"));
        assertThat(itemConjured.getSellIn(), is(-2));
        assertThat(itemConjured.getQuality() , is(6));
        inventory.updateQuality();
        assertThat(items[11].getQuality(), is(2));
    }
}
