public class UDPPacket extends Packet {
    public static final int MAX_PAYLOAD = 1000;
    public static final int HEADER_SIZE = 64;
    public PacketType type = UDP_PACKET;

    public UDPPacket(int payload, Flow flow, int id) {
        super();
        this.size = payload + self.HEADER_SIZE;
        this.flow = flow;
        this.id = id;
    }
}