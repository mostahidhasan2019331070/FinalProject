package com.TracPro.network.server;

import com.TracPro.network.Packet;

public class SystemPacket implements Packet {
    public String command;

    public SystemPacket(String command) {
        this.command = command;
    }
}
