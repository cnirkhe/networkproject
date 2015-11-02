public class ACKPacket extends Packet {
    public static final int MAX_PAYLOAD = 64;
    public PacketType type = ACK_PACKET;

    public Packet(Flow flow, int id) {
        this.size = MAX_PAYLOAD;
        this.flow = flow;
        this.id = id;
    }
}