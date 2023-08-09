package quiz;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            FileReader reader = new FileReader("c:/mine_data/mine.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            reader.close();

            System.out.print(jsonObject);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

}