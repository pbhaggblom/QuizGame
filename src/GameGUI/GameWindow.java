package GameGUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    JPanel panelStart = new JPanel();
    JPanel panelCategories = new JPanel();
    JPanel panelQuestions = new JPanel();
    JLabel label = new JLabel("Quiz Game");
    JButton startButton = new JButton("Starta nytt spel");
    JButton category1 = new JButton("Category 1");
    JButton category2 = new JButton("Category 2");
    JButton question1 = new JButton("Question 1");
    JButton question2 = new JButton("Question 2");
    JButton question3 = new JButton("Question 3");
    JButton question4 = new JButton("Question 4");
    public GameWindow() {
        setTitle("Quiz Game");
        add(panelStart);
        panelStart.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        startWindow(c);

        setSize(400, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public void startWindow(GridBagConstraints c) {
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        panelStart.add(label, c);

        changePanelContent(panelStart, startButton, 0 ,2);
    }
    public void categoryWindow() {
        changePanel(panelCategories);

        changePanelContent(panelCategories, category1, 0, 0);

        changePanelContent(panelCategories, category2, 0, 1);

    }
    public void questionsWindow() {
        changePanel(panelQuestions);

        changePanelContent(panelQuestions, question1, 0, 0);

        changePanelContent(panelQuestions, question2, 0, 1);

        changePanelContent(panelQuestions, question3, 0, 2);

        changePanelContent(panelQuestions, question4, 0, 3);

    }
    public void changePanel(JPanel panel) {
        add(panel);
        panel.setLayout(new GridBagLayout());
    }
    public void changePanelContent(JPanel panel, JButton button, int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        button.setPreferredSize(new Dimension(150, 40));
        button.setSize(100, 40);
        c.gridx = x;
        c.gridy = y;
        panel.add(button, c);
        button.addActionListener(e -> {
            if(panel.equals(panelStart)) {
                panel.setVisible(false);
                categoryWindow();
            }else if (panel.equals(panelCategories)) {
                panel.setVisible(false);
                questionsWindow();
            }
        });
    }
    public static void main(String[] args) {
        new GameWindow();
    }
}


