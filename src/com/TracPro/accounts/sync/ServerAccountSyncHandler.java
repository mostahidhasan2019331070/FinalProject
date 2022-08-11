package com.TracPro.accounts.sync;

import com.TracPro.accounts.Project;
import com.TracPro.accounts.User;
import com.TracPro.network.Packet;
import com.TracPro.network.server.ClientHandler;

import java.io.IOException;

/**
 * Handler for sending and processing account packets
 * on server side (for each user)
 * @author Shibli Noman Sunny
 */
public class ServerAccountSyncHandler {
    // client handler responsible for said user
    private ClientHandler clientHandler;
    // user and project info
    private User user;
    private Project project;

    public ServerAccountSyncHandler(User user, Project project, ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
        this.user = user;
        this.project = project;
    }

    public void receivePacket(Packet packet) {
        AccountPacket accountPacket = (AccountPacket) packet;
        if (accountPacket.command.equals("init")) {
            try {
                clientHandler.sendPacket(
                        new AccountPacket("reset", user, project));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (accountPacket.command.equals("reset")) {
            project = accountPacket.project;
            user = accountPacket.user;
            project.saveToFile();
        }
    }

    private void log(String str) {
        System.out.println(this.getClass().getCanonicalName() + ": " + str);
    }
}
