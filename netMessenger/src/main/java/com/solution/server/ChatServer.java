package com.solution.server;

import com.solution.network.TCPConnection;
import com.solution.network.TCPConnectionListener;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(ChatServer.class);

    public static void main(String[] args) {
        new ChatServer();
    }

    private final ArrayList<TCPConnection> connections = new ArrayList<>();

    private ChatServer(){
        LOG4j2.info("Server is running");
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            while (true){
                try{
                    new TCPConnection(this,serverSocket.accept());
                } catch (IOException e){
                    LOG4j2.info("TCPConnection exception : " + e );
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected: " +  tcpConnection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllConnections(value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Client disconnected: " +  tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        LOG4j2.info("TCPConnection exception : " + e );
    }

    private void sendToAllConnections(String value){
        final int size = connections.size();
        LOG4j2.info(value);
        for (int i = 1; i < size; i++){
            connections.get(i).sendSString(value);
        }
    }
}
