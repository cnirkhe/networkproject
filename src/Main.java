import org.json.JSONObject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputParser ip = new InputParser();
        System.out.println("what");
        ip.parse("test.json");
        ArrayList<Host> hosts = ip.extractHosts();
        ArrayList<Flow> flows = ip.extractFlows();
        RunSim.run(flows, hosts, 1000, 10000);
        System.out.println("done");
    }
}
