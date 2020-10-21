package com.corporation.globevery;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class SocketData implements Serializable {
    public int size = 0;
    public String data = "";
    public SocketData(String data) {
        if (data != null) {
            size = data.length();
            this.data = data;
        }
    }
    public String toString() {
        return size + " " + data;
    }
    public void writeObject(DataOutputStream out) throws IOException {
        out.writeInt(size + 1);
        out.writeBytes(data);
        out.writeByte('\0');
    }
    public void readObject(DataInputStream in) throws IOException {
        size = in.readInt() - 1;
        byte[] aux = null;
        aux = new byte[size];
        in.read(aux, 0, size);
        data = new String(aux);
        in.read(aux, 0, 1);
    }
}
