
import Classes.*;

public class Inventory {

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

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

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i] instanceof Aged_Brie)  items[i].update((Aged_Brie) items[i]);
            if(items[i] instanceof Backstage_passes)  items[i].update((Backstage_passes) items[i]);
            if(items[i] instanceof Conjured_Cake)  items[i].update((Conjured_Cake) items[i]);
            if(items[i] instanceof Dexterity)  items[i].update((Dexterity) items[i]);
            if(items[i] instanceof Elixir)  items[i].update((Elixir) items[i]);
            if(items[i] instanceof Sulfuras)  items[i].update((Sulfuras) items[i]);
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
