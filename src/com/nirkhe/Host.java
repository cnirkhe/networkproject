package com.nirkhe;

/**
 * Created by chinmay on 11/1/15.
 */
public class Host {

    private int address;
    private Link link;
    private int link_buffer_size;

    public Host(int address, Link link, int link_buffer_size)
    {
        this.address = address;
        this.link = link;
        this.link_buffer_size = link_buffer_size;
    }

}
