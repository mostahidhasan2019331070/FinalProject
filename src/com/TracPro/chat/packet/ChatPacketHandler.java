package com.TracPro.chat.packet;

import com.TracPro.network.Packet;
/**
 * A message handler that sends message over the server on client request
 *
 * use to make new message packet
 *
 * Also to extract packet
 *
 * static functions allows us to call the functions without instantiating
 * which contribute to another exclusive feature of OOP
 *
 */

import java.io.File;
public class ChatPacketHandler {
    public static Packet createMessagePacket(String clientUserName, String message){
        return (new MessagePacket(clientUserName, message));
    }

    public static Packet createFilePacket(String clientUserName, File file) throws Exception{
        return (new FilePacket(clientUserName, file));
    }
    public static Packet createFileReqeustPacket(String clientUsername, String fileName){
        return (new FileRequestPacket(clientUsername, fileName));
    }

    public static String extractPacket(Packet packet) {
        if (packet instanceof MessagePacket) {
            MessagePacket messagePacket = (MessagePacket) packet;
            return messagePacket.toString();
        }
        else if (packet instanceof FileRequestPacket) {
            FileRequestPacket fileRequestPacket = (FileRequestPacket) packet;
            return fileRequestPacket.toString();
        }
        else{
            throw new IllegalArgumentException("Illegal packet");
        }
    }

    public static void extractFilePacket(File file, Packet packet) throws Exception{
        if(packet instanceof FilePacket){
            FilePacket filePacket = (FilePacket) packet;
            filePacket.toFile(file);
        }
    }
}
