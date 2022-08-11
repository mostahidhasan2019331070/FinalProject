package com.TracPro.accounts.sync;

import com.TracPro.accounts.Project;
import com.TracPro.accounts.User;
import com.TracPro.network.Packet;
/**
 * A container object for sending user and project data
 * over network
 *
 * @author Shibli Noman Sunny
 */
public class AccountPacket implements Packet {
    public String command;
    public User user;
    public Project project;

    public AccountPacket(String command, User user, Project project) {
        this.command = command;
        this.user = user;
        this.project = project;
    }
}
