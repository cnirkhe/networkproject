import java.util.ArrayList;

/**
 * Created by chinmay on 11/3/15.
 */
public class Flow {
    private int id;
    private Node source;
    private int sourceId;
    private Node destination;
    private int destinationId;
    private ArrayList<Packet> packets;
    private int startTime;
    //public int packetID; <- need multiple packets per flow

    public int takePayload() {
        return 0;
    }

    public Flow(int id, int sourceId, Node source, int destinationId, Node destination,
                int startTime, ArrayList<Packet> packets) {
        this.source = source;
        this.sourceId = sourceId;
        this.destination = destination;
        this.destinationId = destinationId;
        this.startTime = startTime;
        this.id = id;
        this.packets = packets;
    }

    public int getId() { return this.id; }

    // Dummy function for updating. Will eventually change the flow based on what happened in
    // one time interval.
    public void update(final int intervalTimeMillis) {
        System.out.println("flow updated");
    }
}
