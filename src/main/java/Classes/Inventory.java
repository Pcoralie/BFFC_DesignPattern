package Classes;

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
                new Conjured_Cake("Conjured Mana Cake", 3, 6),
                new Aged_Brie("Aged Brie", -2, 3),
                new Conjured_Cake("Conjured Mana Cake", -2, 6),
                new Dexterity("+5 Dexterity Vest", -2, 20),
                new Elixir("Elixir of the Mongoose", -2, 7),
                new Backstage_passes("Backstage passes to a TAFKAL80ETC concert", 8, 45),
                new Backstage_passes("Backstage passes to a TAFKAL80ETC concert", 3, 20)
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
            items[i].updateQuality();
        }
    }

    public void updateSellin()
    {
        for (int i = 0; i < items.length; i++) {
            items[i].sellIn--;
        }
    }

    public void updateAll()
    {
        this.updateSellin();
        this.updateQuality();
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
