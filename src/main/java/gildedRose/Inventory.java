
package gildedRose;

public class Inventory {

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    /*
    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };

    }

*/


    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    /*
    public void updateQuality() {
        for (Item item : items) {
            Item category = categorize(item);
            category.updateOneItem(item);
        }
    }

    private Item categorize(Item item){
        if (item.name.equals("Legendary, Hand of Ragnaros")){
            return new Legendary();
        }
        if (item.name.equals("Aged Brie")){
            return new Cheese();
        }
        if (item.name.equals("Backstage passes to a  TAFKAL80ETC concert")){
            return new BackstagePass();
        }
        if (item.name.startsWith("Conjured")){
            return new Conjured();
        }
        return new Item();
    }
    */

    /*
     public Inventory() {
        super();
        items = new Item[]{
                new Dexterity("+5 Dexterity Vest", 10, 20),
                new Aged_Brie("Aged Brie", 2, 0),
                new Elixir("Elixir of the Mongoose", 5, 7),
                new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),
                new Backstage_passes("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Conjured_Cake("Conjured Mana Cake", 3, 6)
        };
    }
     */

    public Inventory() {
        super();
        items = new Item[]{
                new Dexterity("+5 Dexterity Vest", 10, 20),
                new Cheese("Aged Brie", 2, 0),
                new Elixir("Elixir of the Mongoose", 5, 7),
                new Legendary("Legendary, Hand of Ragnaros", 0, 80),
                new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Conjured("Conjured Mana Cake", 3, 6),
                new Dexterity("+6 Dexterity Pants", -2, 20),
                new Cheese("Aged Camembert", -2, 5),
                new Elixir("Elixir of the Elders", -2, 7),
                new BackstagePass("Backstage passes to a TAFKAL80ETC concert 2", 8, 20),
                new BackstagePass("Backstage passes to a TAFKAL80ETC concert 3", 3, 20),
                new Conjured("Conjured Health Cake", -2, 6)

        };

    }

    /*
      public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i] instanceof Cheese)  items[i].update((Cheese) items[i]);
            if(items[i] instanceof Backstage_passes)  items[i].update((Backstage_passes) items[i]);
            if(items[i] instanceof Conjured_Cake)  items[i].update((Conjured_Cake) items[i]);
            if(items[i] instanceof Dexterity)  items[i].update((Dexterity) items[i]);
            if(items[i] instanceof Elixir)  items[i].update((Elixir) items[i]);
            if(items[i] instanceof Sulfuras)  items[i].update((Sulfuras) items[i]);
        }
    }
     */

     public void updateQuality(){

        for (int i = 0; i < items.length; i++) {

            if(items[i] instanceof Cheese)  items[i].updateOneItem((Cheese) items[i]);

            if(items[i] instanceof BackstagePass)  items[i].updateOneItem((BackstagePass) items[i]);

            if(items[i] instanceof Conjured)  items[i].updateOneItem((Conjured) items[i]);

            if(items[i] instanceof Dexterity)  items[i].updateOneItem((Dexterity) items[i]);

            if(items[i] instanceof Elixir)  items[i].updateOneItem((Elixir) items[i]);

            if(items[i] instanceof Legendary)  items[i].updateOneItem((Legendary) items[i]);

        }

    }







    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }

    public Item[] getItems() {
        return items;
    }
}
