package gildedRose;

import gherkin.deps.com.google.gson.JsonSerializer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;


public class JSONcode {

    public static void main(String[] args) throws IOException {
        /*
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();

        System.out.print(jsonText);
        */

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("inventory.json"));
            JSONObject jsonObject =(JSONObject) obj;
            String name = (String) jsonObject.get("Name");
            Integer sellIn = (Integer) jsonObject.get("SellIn");
            Integer quality = (Integer) jsonObject.get("Quality");
            JSONArray inventory = (JSONArray) jsonObject.get("Inventory");

            System.out.println("Name" + name);
            System.out.println("SellIn" + sellIn);
            System.out.println("\nInventory:");
            Iterator<String> iterator = inventory.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    String fileToRead = "inventory.json";
    StreamReader fileReader = new StreamReader(fileToRead);
    JsonSerializer jsonSerialiser = new JsonSerializer();
    List<Item> items  = (List<Item>)jsonSerialiser.Deserialize(fileReader, typeof(List<Item>));
            fileReader.Close();
       */

}
