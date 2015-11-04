/**
 * Created by chinmay on 11/3/15.
 */
public abstract class Flow {

    public int packetID;

    public int takePayload() {
        return 0;
    }

    public Flow() {}

    // Dummy function for updating. Will eventually change the flow based on what happened in
    // one time interval.
    public void update(final int intervalTimeMillis) {
        // pass
    }
}
