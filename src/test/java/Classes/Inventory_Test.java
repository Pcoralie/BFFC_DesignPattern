package Classes;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Inventory_Test {

    protected Inventory inv;

    Item[] oldItemList;

    @Before
    public void setUp()
    {
        inv = new Inventory();
        oldItemList = inv.getItems();
    }


    @Test
    public void sellinCheck()
    {
        inv.updateAll();

        for(int i=0 ; i<inv.getItems().length; i++){
            if (oldItemList[i].getSellIn()==0)
            {
                TestCase.assertEquals(oldItemList[i].getSellIn()-1 , inv.getItems()[i].getSellIn());
            }
        }
    }



    @Test
    public void limitQualityCheck()
    {
        boolean error = false;

        for(int i = 0; i<30; i++)
        {
            inv.updateAll();
            for(int j=0; j<inv.getItems().length; j++)
            {
                if(inv.getItems()[j].getName() != "Sulfuras, Hand of Ragnaros")
                {
                    if((inv.getItems()[j].getQuality()<0) || (inv.getItems()[j].getQuality()>50))
                    {
                        error = true;
                        break;
                    }
                }
            }
        }

        assertThat(error, is(false));
    }
}
