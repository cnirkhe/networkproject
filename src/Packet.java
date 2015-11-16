public abstract class Packet {

    public int size;
    public Flow flow;
    public int id;
    public int flowId;

    public int getFlowId() { return this.flowId; }
}