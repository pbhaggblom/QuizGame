package server;

import java.io.*;
import java.net.Socket;

public class Player {

    Socket socket;
    String name;
    BufferedReader in;
    PrintWriter out;

    public Player(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String receive() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
