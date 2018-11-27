package Classes;

import org.junit.*;
import junit.framework.TestCase;

public class InventoryTest {
    protected Inventory inv;

    Item[] ancienneListeDesItems ;

    @Before
    public void setUp(){
        inv = new Inventory();
        ancienneListeDesItems = inv.getItems();

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testUpdateQualityWhenSellInFinished() throws Exception {
        inv.updateQuality();
        Item[] items = inv.getItems();
        for(int i=0 ; i<items.length; i++){
            if (ancienneListeDesItems[i].getSellIn()==0)
            {
                TestCase.assertEquals(ancienneListeDesItems[i].getQuality()-2 , items[i].getQuality());
            }
        }
    }

}
