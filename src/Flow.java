/**
 * Created by chinmay on 11/3/15.
 */
public class Flow {
    private int source;
    private int destination;
    //private Queue<Packet> packets;
    private int startTime;
    //public int packetID; <- need multiple packets per flow

    public int takePayload() {
        return 0;
    }

    public Flow(int source, int destination, int startTime) {
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
    }

    // Dummy function for updating. Will eventually change the flow based on what happened in
    // one time interval.
    public void update(final int intervalTimeMillis) {
        System.out.println("flow updated");

    }
}
