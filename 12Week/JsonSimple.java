package quiz;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JsonSimple {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "Han tae young");
        obj.put("mine", "always angry");
        obj.put("year", 2023);

        try {
            FileWriter file = new FileWriter("c:/Temp/simple.json");
            file.write(obj.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(obj);

    }

}