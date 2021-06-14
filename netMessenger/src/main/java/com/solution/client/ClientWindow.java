package com.solution.client;

import com.solution.network.TCPConnection;
import com.solution.network.TCPConnectionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Class {@code ClientWindow}
 * Was created for client to use
 */
public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {

    private static  final String IP_ADDRESS = "192.168.0.1";
    private static  final int PORT = 8189;
    private static  final int WIDTH = 600; // width of client window
    private static  final int HEIGHT = 400; // height of client window


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientWindow();
            }
        });
    }


     private final JTextArea log = new JTextArea();
     private final JTextField fieldNickName = new JTextField("Test");
     private final JTextField fieldInput = new JTextField();

     private TCPConnection connection;

/**
 * private constructor for ClientWindow
 */
private ClientWindow(){
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // closing client’s window
    setSize(WIDTH,HEIGHT); // set client’s window parameters
    setLocationRelativeTo(null); // client’s window will be in the center
    setAlwaysOnTop(true); // client’s window will be on the top


    log.setEditable(false);// prohibition of editing
    log.setLineWrap(true); // automatic word wrap
    add(log, BorderLayout.CENTER);

    fieldInput.addActionListener(this);//transferring the user
    add(fieldInput, BorderLayout.SOUTH);
    add(fieldNickName, BorderLayout.NORTH);

    setVisible(true); // demonstration of client’s window

    try {
        connection = new TCPConnection(this,IP_ADDRESS,PORT); // created connection
    } catch (IOException e) {
        printMsg("Connection exception" + e);
    }


}

    @Override
    public void actionPerformed(ActionEvent e) {
    String msg = fieldInput.getText();
    if(msg.equals("")) return;
    fieldInput.setText(null);
    connection.sendSString(fieldNickName.getText() + ":" + msg);
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connection ready ");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMsg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Connection closed ");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
    printMsg("Connection exception" + e);
    }


    /**
     * Created method printMsg for logging
     * @param msg a String contains the message
     */
    private synchronized void printMsg (final String msg){
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            log.append(msg +"\n");
            log.setCaretPosition(log.getDocument().getLength());
        }
    });
    }
}
