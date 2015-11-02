abstract public class Packet {
    public static final int MAX_PAYLOAD;
    public static final int HEADER_SIZE;

    public int size;
    public Flow flow;
    public int id;
}