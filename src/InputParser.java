import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by chinmay on 11/2/15.
 */
public class InputParser {

    /**
     * Using org.json parsing tools
     */
    private JSONParser parser;
    private JSONObject jsonObject;

    public InputParser() {
        parser = new JSONParser();
    }

    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method to run for parsing
     * @param fileLocation Location of JSON object in relation to
     */
    public void parse(String fileLocation) {
        jsonObject = buildJSONObject(fileLocation);
    }

    private JSONObject buildJSONObject(String fileLocation) {
        JSONObject jsonObject = null;
        try {
            String jsonData = readFile(fileLocation);
            jsonObject = new JSONObject(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    public ArrayList<Host> extractHosts() {
        ArrayList<Host> output = new ArrayList<>();
        try {
            JSONArray hostArray = jsonObject.getJSONObject("network").getJSONArray("hosts");
            for (int i = 0; i < hostArray.length(); ++i) {
                JSONObject hostJson = hostArray.getJSONObject(i);
                // Host(address, link)
                int address = hostJson.getInt("address");
                int linkId = hostJson.getInt("link");
                int linkBufferSize = hostJson.getInt("linkBufferSize");
                output.add(new Host(address, linkId, linkBufferSize));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return output;
    }

    public ArrayList<Link> extractLinks() {
        ArrayList<Link> output = new ArrayList<>();
        try {
            JSONArray linkArray = jsonObject.getJSONObject("network").getJSONArray("links");
            for (int i = 0; i < linkArray.length(); ++i) {
                JSONObject linkJson = linkArray.getJSONObject(i);
                int id = linkJson.getInt("id");
                int capacity = linkJson.getInt("capacity");
                int transmissionDelay = linkJson.getInt("transmissionDelay");
                output.add(new Link(id, capacity, transmissionDelay));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return output;
    }

    public ArrayList<Packet> extractPackets(){
        ArrayList<Packet> output = new ArrayList<>();
        try {
            JSONArray packetArray = jsonObject.getJSONObject("network").getJSONArray("packets");
            for (int i = 0; i < packetArray.length(); ++i) {
                JSONObject packetJson = packetArray.getJSONObject(i);
                int size = packetJson.getInt("size");
                int flowId = packetJson.getInt("flow");
                int id = packetJson.getInt("id");
                output.add(new TCPPacket(size, flowId, id));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return output;
    }

    public ArrayList<Flow> extractFlows() {
        ArrayList<Flow> output = new ArrayList<>();
        try {
            JSONArray flowArray = jsonObject.getJSONObject("network").getJSONArray("flows");
            for (int i = 0; i < flowArray.length(); ++i) {
                JSONObject flowJson = flowArray.getJSONObject(i);
                int source = flowJson.getInt("source");
                int destination = flowJson.getInt("destination");
                int startTime = flowJson.getInt("startTime");
                output.add(new Flow(source, destination, startTime));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return output;
    }

    public ArrayList<Router> extractRouters() {
        ArrayList<Router> output = new ArrayList<>();
        try {
            JSONArray routerArray = jsonObject.getJSONObject("network").getJSONArray("routers");
            for (int i = 0; i < routerArray.length(); ++i) {
                JSONObject routerJson = routerArray.getJSONObject(i);
                int address = routerJson.getInt("address");
                output.add(new Router(address));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return output;
    }
}
