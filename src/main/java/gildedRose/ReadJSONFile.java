package gildedRose;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;


public class ReadJSONFile {

    public static void main(String[] args) throws IOException {
        JSONParser parser = new JSONParser();
        try{
            /*

            InputStream is = ReadJSONFile.class.getResourceAsStream("/main/resources/inventory.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            System.out.println(reader);
            Object obj = parser.parse(new BufferedReader(new InputStreamReader(is)));

            //TUTO
            Object obj = parser.parse(new FileReader("myJSON.json"));
            JSONObject jsonObject =(JSONObject) obj;
            String name = (String) jsonObject.get("name");
            String sellIn = (String) jsonObject.get("sellIn");
            String quality = (String) jsonObject.get("quality");
            System.out.println("Name" + name);
            System.out.println("SellIn" + sellIn);
            System.out.println("quality" + quality);

            //loop array:
            JSONArray inventory =(JSONArray) jsonObject.get("inventory");
            System.out.println("\nInventory:");
            Iterator<String> iterator = inventory.iterator();
            while(iterator.hasNext()) {
                System.out.println("Item  " + iterator.next());
            }
            */

            Object obj = parser.parse(new FileReader("inventory.json"));
            JSONObject jsonObject =(JSONObject) obj;
            JSONArray inventory =(JSONArray) jsonObject.get("inventory");
            System.out.println("\nInventory:");
            Iterator<Item> iterator = inventory.iterator();
            while(iterator.hasNext()) {
                System.out.println("Item  " + iterator.next());
            }



        }catch(FileNotFoundException e){
            System.out.println("json file isn't found");
            e.printStackTrace();
        }catch(IOException e ){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
