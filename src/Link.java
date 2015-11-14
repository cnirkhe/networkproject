public class Link {
    private int capacity;               // bits per milli-second
    private float transmissionDelay;    // milli-seconds
    private int id;                     // link id
    private int cost;

    private Node connection_0;
    private Node connection_1;
    
    // constructors
    public Link(int id, int capacity, float transmissionDelay, int cost) {
        this(id, capacity, transmissionDelay, null, null, cost);
    }
    public Link(int id, int capacity, float transmissionDelay, Node node0, Node node1, int cost) {
        this.capacity = capacity;
        this.transmissionDelay = transmissionDelay;
        this.id = id;
        connection_0 = node0;
        connection_1 = node1;
        this.cost = cost;
    }

    // private variable accessors and modifiers
    public int getCapacity() {
        return this.capacity;
    }
    public float getTransmissionDelay() {
        return this.transmissionDelay;
    }
    public int getCost() { return this.cost; }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setTransmissionDelay(int transmissionDelay) {
        this.transmissionDelay = transmissionDelay;
    }
    public void setCost(int cost) {this.cost = cost; }

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