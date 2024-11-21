package GameGUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Quiz Game");
    public JButton startButton = new JButton("Starta nytt spel");
    JButton category1 = new JButton("Category 1");
    JButton category2 = new JButton("Category 2");
    public GameWindow() {
        add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        startWindow(c);

        setSize(400, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public void startWindow(GridBagConstraints c) {
        startButton.setPreferredSize(new Dimension(150, 40));
        startButton.setSize(100, 40);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(startButton, c);

        startButton.addActionListener(e -> {
            System.out.println("Spelet startar");
        });
    }
    public void categoryWindow(GridBagConstraints c) {
        category1.setPreferredSize(new Dimension(150, 40));
        category1.setSize(100, 40);
        c.gridx = 0;
        c.gridy = 2;
    }
}


