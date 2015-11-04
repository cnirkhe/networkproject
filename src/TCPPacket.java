public class TCPPacket extends Packet {
    public static final int MAX_PAYLOAD = 1000;
    public static final int HEADER_SIZE = 64;
//    public PacketType type = TCP_PACKET;

    public TCPPacket(int payload, Flow flow, int id) {
        this.size = payload + HEADER_SIZE;
        this.flow = flow;
        this.id = id;
    }
}