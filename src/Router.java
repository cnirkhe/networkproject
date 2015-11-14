

import com.sun.tools.javac.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Elaine on 11/10/2015.
 */
public class Router extends Node {
    private Integer address;
    private ArrayList<Link> links;
    /** Map from router address to Pair<distance, link index to use> **/
    private HashMap<Integer, Pair<Integer,Integer>> routingTable;

    public Router(Integer address) {
        this(address, new ArrayList<Link>());
    }

    public Router(Integer address, ArrayList<Link> links) {
        this.address = address;
        this.links = links;
        initializeRoutingTable();
    }

    public void initializeRoutingTable()
    {
        routingTable = new HashMap<>();
        routingTable.put(address, Pair.of(0,-1));
    }

    /**
     * This method updates this routers routing table given the following information by the Bellman-Ford algorithm
     * @param neighborAddress
     * @param connectingLinkIndex
     * @param neighborRoutingTable
     */
    public void updateRoutingTable(Integer neighborAddress, Integer connectingLinkIndex,
                                   HashMap<Integer,Pair<Integer,Integer>> neighborRoutingTable) {

        Pair<Integer,Integer> neighborInformation = Pair.of(links.get(connectingLinkIndex).getCost(), connectingLinkIndex);
        routingTable.put(neighborAddress, neighborInformation); //If data exists, overwrites but equivalent time as check and rewrite

        // Now we update our routing table using the triangle inequality and all of the information in the neighbor's routing table
        for( Integer routerAddress : neighborRoutingTable.keySet()) {
            Pair<Integer, Integer> routerInformation = neighborRoutingTable.get(routerAddress);
            Pair<Integer, Integer> myCurrentInformation = routingTable.getOrDefault(routerAddress, Pair.of(Integer.MAX_VALUE, -1));
            if(routerInformation.fst + neighborInformation.fst < myCurrentInformation.fst) {
                //Change the routing to go through neighbor router
                myCurrentInformation = Pair.of(routerInformation.fst + neighborInformation.fst, connectingLinkIndex);
                routingTable.put(routerAddress, myCurrentInformation);
            }
        }
    }

    public void broadcastUpdate() {
        //Construct flow to each of the neighbors (not equal to itself)
        for(Link l : links) {
            Node otherEnd = l.getOtherEnd(this);

            Flow f = new Flow(l, otherEnd, /* TODO: Start Time */);
            /* TODO: Send this flow to the scheduler, also the flow has to include the router table information */
        }
    }
}

