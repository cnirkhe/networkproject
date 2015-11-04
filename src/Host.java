import java.util.HashMap;
import java.util.LinkedList;

public class Host extends Node {
    private int address;
    private Link link;

    /**
     * Queue of flows out of this host
     */
    private LinkedList<Flow> outFlows = new LinkedList<Flow>();
    /**
     * Queue of ACK packets this host has to send
     */
    public LinkedList<Packet> ackPackets = new LinkedList<Packet>();

    /**
     * Packet this host is currently sending
     */
    private Packet sendingPacket;
    // Number of bits of the current packet that have been sent
    private int sentBits;
    // Packets this host is in the process of receiving
    private HashMap<Packet, Integer> receivingPackets =
            new HashMap<Packet, Integer>();

    public Host(int address, Link link) {
        this.address = address;
        this.link = link;
    }

//    /*
//     * Gets a packet to send across the link.
//     */
//    public Packet getPacketToSend() {
//        // If we're not in the middle of sending a packet...
//        if (this.sendingPacket == null) {
//            // Take the first flow, increase its packet ID, and take a payload
//            Flow flow = outFlows.remove();
//            flow.packetID += 1;
//            int payload = flow.takePayload();
//
//            // Create either a TCP or UDP packet to transfer the flow's data
//            if (flow instanceof TCPPacket) {
//                this.sendingPacket = new TCPPacket(payload, flow,
//                        flow.packetID);
//            } else {
//                this.sendingPacket = new UDPPacket(payload, flow,
//                        flow.packetID);
//            }
//
//            // Update the number of bits being sent
//            this.sentBits = 0;
//            // Put the flow at the back of the queue
//            outFlows.add(flow);
//        }
//
//        // Return the packet being currently sent
//        return this.sendingPacket;
//    }
//
//    /*
//     * Updates the status of the currently sending packet.
//     */
//    public void sendBits(int bitCount) {
//        // Update the set bit count, and check if we've finished the packet
//        this.sentBits += bitCount;
//        if (this.sentBits == this.sendingPacket.size)
//            this.sendingPacket = null;
//    }
//
//    /*
//     * Handles the reception of some amount of bits a packets.
//     */
//    public void receive(Packet packet, int bitCount) {
//        // If this is an ACK packet, update the corresponding flow's window
//        if (packet instanceof ACKPacket) {
//            // Handle ACK packet
//            return;
//        }
//
//        // Otherwise, check how many bits of the packet we already have
//        Integer previousBitCount =this.receivingPackets.get(packet);
//        // If we don't have any of the packet yet...
//        if (previousBitCount == null) {
//            // ...check if we received the whole thing, and if so create an ACK
//            if (bitCount == packet.payload) {
//                self.ackPackets.add(new ACKPacket(packet.flow, packet.id));
//            }
//            // Otherwise, record that we've started receiving this packet
//            else
//                self.receivingPackets.put(packet, bitCount);
//        }
//        // If we do have some of the packet...
//        else {
//            // Check if we received the rest, and if so create an ACK
//            bitCount += previousBitCount;
//            if (bitCount == packet.size) {
//                self.ackPackets.add(new ACKPacket(packet.flow, packet.id));
//                // We're done receiving this packet
//                self.receivingPackets.remove(packet);
//            }
//            // Otherwise, update the reception's progress
//            else {
//                self.receivingPackets.put(packet, bitCount);
//            }
//        }
//    }
}
