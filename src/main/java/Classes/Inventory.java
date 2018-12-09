package Classes;

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


    public Inventory() {
        super();
        items = new Item[]{
                new Dexterity("+5 Dexterity Vest", 10, 20),
                new Cheese("Aged Brie", 2, 0),
                new Elixir("Elixir of the Mongoose", 5, 7),
                new Legendary("Legendary, Hand of Ragnaros", 0, 80),
                new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Conjured("Conjured Mana Cake", 3, 6)
        };

    }

     public void updateQuality(){

        for (int i = 0; i < items.length; i++) {

            if(items[i] instanceof Cheese)  items[i].updateQuality((Cheese) items[i]);

            if(items[i] instanceof BackstagePass)  items[i].updateQuality((BackstagePass) items[i]);

            if(items[i] instanceof Conjured)  items[i].updateQuality((Conjured) items[i]);

            if(items[i] instanceof Dexterity)  items[i].updateQuality((Dexterity) items[i]);

            if(items[i] instanceof Elixir)  items[i].updateQuality((Elixir) items[i]);

            if(items[i] instanceof Legendary)  items[i].updateQuality((Legendary) items[i]);

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
