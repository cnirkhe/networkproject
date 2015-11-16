public class Link {
    private int capacity;               // bits per milli-second
    private float transmissionDelay;    // milli-seconds
    private int id;                     // link id
    private int bufferSize;             // size of buffer

    private Node connection_0;
    private Node connection_1;
    
    // constructors
    public Link(int id, int capacity, float transmissionDelay, int bufferSize) {
        this(id, capacity, transmissionDelay, bufferSize, null, null);
    }
    public Link(int id, int capacity, float transmissionDelay, int bufferSize, Node node0, Node node1) {
        this.capacity = capacity;
        this.transmissionDelay = transmissionDelay;
        this.id = id;
        this.bufferSize = bufferSize;
        connection_0 = node0;
        connection_1 = node1;
    }

    // private variable accessors and modifiers
    public int getId() {return this.id; }
    public int getCapacity() {
        return this.capacity;
    }
    public float getTransmissionDelay() {
        return this.transmissionDelay;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setTransmissionDelay(int transmissionDelay) {
        this.transmissionDelay = transmissionDelay;
    }

    // connection functionality
    public boolean connect(Node node) {
        if (connection_0 == null) {
            connection_0 = node;
            return true;
        } else if (connection_1 == null) {
            connection_1 = node;
            return true;
        }
        return false;
    }
    public boolean disconnect(Node node) {
        if (connection_0 == node) {
            connection_0 = null;
            return true;
        } else if (connection_1 == node) {
            connection_1 = null;
            return true;
        }
        return false;
    }
}