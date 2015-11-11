import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Elaine on 11/10/2015.
 */
public class Router {
    private int address;
    private ArrayList<Integer> links;
    private HashMap<Integer, Integer> routingTable;

    public Router(int address) {
        this.address = address;
    }
}

