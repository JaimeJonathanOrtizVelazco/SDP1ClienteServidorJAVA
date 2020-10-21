package com.corporation.globevery;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketServer {
    private Socket socketConnection;

    public SocketServer(Socket socketConnection) {
        this.socketConnection = socketConnection;
    }
    public void run() {
        SocketData data=null;
        SocketData recib=null;
        try {
            this.socketConnection.setSoLinger(true, 10);
            data = new SocketData("Hola" + " ");
            DataOutputStream out = new DataOutputStream(this.socketConnection.getOutputStream());
            data.writeObject(out);
            System.out.println("Enviado: " + data.toString());
            DataInputStream in = new DataInputStream(this.socketConnection.getInputStream());
            recib = new SocketData("");
            recib.readObject(in);
            System.out.println("Recibido: " + recib.toString());
            this.socketConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
