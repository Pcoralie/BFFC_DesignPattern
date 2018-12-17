package gildedRose.controller;

import gildedRose.model.Item;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GUIUnitTests {

    protected Item[] ancienneListe;
    protected ShopView shopViewTest;

    @Test
    public void LoadFileTest()
    {
        ShopView shopViewTest = new ShopView();
        shopViewTest.OnLoadFile();
        assertThat(shopViewTest.globalInventory.getItems().length, is(12));
    }

    @Test
    public void updateShopTest()
    {
        shopViewTest = new ShopView();
        shopViewTest.OnLoadFile();
        assertThat(shopViewTest.globalInventory.getItems()[0].getSellIn(), is (10));
        shopViewTest.globalInventory.updateQuality();
        assertThat(shopViewTest.globalInventory.getItems()[0].getSellIn(), is (9));


    }


    /*@Test
    public void BuyItemTest()
    {
        ShopView shopViewTest = new ShopView();

    }

    @Test
    public void SelItemTest()
    {

    }*/

}
