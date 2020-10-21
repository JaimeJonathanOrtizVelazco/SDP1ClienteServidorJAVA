package com.corporation.globevery;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        Socket socket = null;
        SocketData data = null;
        SocketData aux = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            socket = new Socket("127.0.0.1", 4444);
            socket.setSoLinger(true, 10);
            in = new DataInputStream(socket.getInputStream());
            data = new SocketData("");
            data.readObject(in);
            System.out.println("Recibido: " + data.toString());
            out = new DataOutputStream(socket.getOutputStream());
            aux = new SocketData("Adios" + " ");
            aux.writeObject(out);
            System.out.println("Enviado: " + aux.toString());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
