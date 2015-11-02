public class Host {
    private int address;
    private Link link;

    private int bitsToSend;
    private int bitsReceived;
    
    private Packet packetToSend;
    private 

    public Host(int address, Link link, int bitsToSend) {
        this.address = address;
        this.link = link;
        this.bitsToSend = bitsToSend;
        this.bitsReceived = 0;
    }

    public Boolean connect(Link link) {
        if (self.link == null && link.connect(self)) {
            self.link = link;
            return true;
        }
        else
            return false;
    }

    public Boolean disconnect() {
        if (self.link == null)
            return false;
        else {
            self.link.disconnect(self);
            self.link = null;
            return true;
        }
    }

    public void tryToSend() {
        if (self.bitsToSend >= packetToSend.MAX_PAYLOAD)
        self.link.wantToSend(self, self.bitsToSend);
    }

    public void didSend(int bitsSent) {
        self.bitsToSend -= bitsSent;
    }

    public void 
}
