public class TCPPacket extends Packet {
    public static final int MAX_PAYLOAD = 1000;
    public static final int HEADER_SIZE = 64;
//    public PacketType type = TCP_PACKET;

    public TCPPacket(int payload, int flowId, int id) {
        this.size = payload + HEADER_SIZE;
        this.flowId = flowId;
        this.id = id;
    }
}