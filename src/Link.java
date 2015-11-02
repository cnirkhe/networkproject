public class Link {
    private int capacity;               // bits per milli-second
    private float transmissionDelay;    // milli-seconds
    //
    public Link(int capacity, float transmissionDelay) {
        this.capacity = capacity;
        this.transmissionDelay = transmissionDelay;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public float getTransmissionDelay() {
        return this.transmissionDelay;
    }
    public void setCapacity() {
        this.capacity = capacity;
    }
    public void setTransmissionDelay() {
        this.transmissionDelay = transmissionDelay;
    }
}