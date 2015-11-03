import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by chinmay on 11/2/15.
 */
public class InputParser {

    /**
     * Using org.json parsing tools
     */
    JSONParser parser;

    public InputParser() {
        parser = new JSONParser();
    }

    /**
     * Method to run for parsing
     * @param fileLocation Location of JSON object in relation to 
     */
    public parse(String fileLocation) {
        JSONObject jsonObject = buildJSONObject(fileLocation);
    }

    private JSONObject buildJSONObject(String fileLocation) {
        try {
                Object obj = parser.parse(new FileReader(fileLocation));
                JSONObject jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
