package gildedRose;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class CreateJSONFile {

    public static void main(String[] args) throws IOException {

        JSONObject obj = new JSONObject();

        obj.put("name", "");
        obj.put("sellIn", "");
        obj.put("quality", "");
        /*
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

         */
        JSONArray inventory = new JSONArray();
        inventory.add("item1");
        inventory.add("item2");

        obj.put("inventory" , inventory);

        try(FileWriter file = new FileWriter("myJSON.json"))
        {
            file.write(obj.toString());
            file.flush();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        System.out.println(obj);
        /*
        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();

        System.out.print(jsonText);
        */
    }
}
