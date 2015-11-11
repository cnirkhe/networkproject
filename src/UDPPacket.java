public class UDPPacket extends Packet {
    public static final int MAX_PAYLOAD = 1000;
    public static final int HEADER_SIZE = 64;
//    public PacketType type = UDP_PACKET;

    public UDPPacket(int payload, int flowId, int id) {
        this.size = payload + HEADER_SIZE;
        this.flowId = flowId;
        this.id = id;
    }
}