package GameGUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    JPanel panelStart = new JPanel();
    JPanel panelCategories = new JPanel();
    JPanel panelQuestions = new JPanel();
    JLabel label = new JLabel("Quiz Game");
    JButton startButton = new JButton();
    JButton category1 = new JButton();
    JButton category2 = new JButton();
    JButton question1 = new JButton();
    JButton question2 = new JButton();
    JButton question3 = new JButton();
    JButton question4 = new JButton();
    public GameWindow() {
        setTitle("Quiz Game");
        add(panelStart);
        panelStart.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        startWindow(c);

        setSize(400, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public void startWindow(GridBagConstraints c) {
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        panelStart.add(label, c);

        changePanelContent(panelStart, startButton, 0 ,2, "Start game");
    }
    public void categoryWindow() {
        changePanel(panelCategories);

        changePanelContent(panelCategories, category1, 0, 0, "Category 1");

        changePanelContent(panelCategories, category2, 1, 0, "Category 2");

    }
    public void questionsWindow() {
        changePanel(panelQuestions);

        changePanelContent(panelQuestions, question1, 0, 0, "Question 1");

        changePanelContent(panelQuestions, question2, 1, 0, "Question 2");

        changePanelContent(panelQuestions, question3, 0, 1, "Question 3");

        changePanelContent(panelQuestions, question4, 1, 1, "Question 4");

    }
    public void changePanel(JPanel panel) {
        add(panel);
        panel.setLayout(new GridBagLayout());
    }
    public void changePanelContent(JPanel panel, JButton button, int x, int y, String text) {
        GridBagConstraints c = new GridBagConstraints();
        button.setPreferredSize(new Dimension(150, 70));
        button.setSize(100, 40);
        button.setText(text);
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(10, 10, 10, 10);

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


