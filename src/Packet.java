abstract public class Packet {
    public static final int MAX_PAYLOAD;

    public int size;
    public int payload;

    public int sourceAddress;
    public int destAddress;

    public Packet(int size, int payload, int sourceAddress, int destAddress) {
        this.size = size;
        this.payload = payload;
        this.sourceAddress = sourceAddress;
        this.destAddress = destAddress;
    }
}