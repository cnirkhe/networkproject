import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        InputParser ip = new InputParser();
        System.out.println("what");
        ip.parse("test.json");
        ArrayList<Link> links = ip.extractLinks();
        HashMap<Integer, Link> linkMap = ip.makeLinkMap(links);
        ArrayList<Packet> packets = ip.extractPackets();
        ArrayList<Router> routers = ip.extractRouters(linkMap);
        ArrayList<Host> hosts = ip.extractHosts(linkMap);
        HashMap<Integer, Node> addressBook = ip.makeNodeMap(routers, hosts);
        ArrayList<Flow> flows = ip.extractFlows(addressBook, packets);
        RunSim.run(flows, hosts, 1000, 10000);
        System.out.println("done");
    }
}
