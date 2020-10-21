package com.corporation.globevery;

import java.net.*;
import java.io.*;

public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(4444);
        } catch (IOException var4) {
            System.err.println("Error en el puerto 4444.");
            System.exit(-1);
        }
        (new SocketServer(socket.accept())).run();
    }

}
