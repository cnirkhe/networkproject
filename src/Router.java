import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Elaine on 11/10/2015.
 */
public class Router extends Node {
    private ArrayList<Link> links;
    private HashMap<Integer, Integer> routingTable;

    public Router(int address, ArrayList<Link> links) {
        this.address = address;
        this.links = links;
    }
}

