package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame implements ActionListener {

    JPanel p = new JPanel();
    JButton b = new JButton("Tryck");
    PrintWriter out;

    public Client() {
        add(p);
        add(b);
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try (Socket s = new Socket("127.0.0.1", 55555);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            b.addActionListener(e -> out.println("Tryckt på knapp"));

            out.println("test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
