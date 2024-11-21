package client;

import server.TheQuiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame implements ActionListener {

    JPanel p = new JPanel();
    JButton b = new JButton("Tryck");
    PrintWriter out;
    BufferedReader in;
    Socket s;

    public Client() {
        add(p);
        add(b);
        b.addActionListener(this);
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            s = new Socket("127.0.0.1", 55555);
            out = new PrintWriter(s.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println("connected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String fromServer;
        while (true) {
            try {
                fromServer = in.readLine();
                if (fromServer.equals("inaktiv")) {
                    b.setEnabled(false);
                } else if (fromServer.equals("aktiv")) {
                    b.setEnabled(true);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        out.println("Knapptryck");
    }
}
