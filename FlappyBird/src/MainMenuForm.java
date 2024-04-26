/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Latihan Praktikum 7 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuForm extends JFrame {
    private JButton startButton;

    public MainMenuForm() {
        setTitle("Flappy Bird");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        add(panel);

        JLabel titleLabel = new JLabel("Flappy Bird");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(139, 0, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        panel.add(buttonPanel, BorderLayout.CENTER);

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(139, 0, 0));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setOpaque(true);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(165, 42, 42));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(139, 0, 0));
            }
        });

        buttonPanel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                startGame();
            }
        });
    }

    private void startGame() {
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBird game = new FlappyBird();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainMenuForm mainMenu = new MainMenuForm();
        mainMenu.setVisible(true);
    }
}
