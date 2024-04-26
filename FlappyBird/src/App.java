/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Latihan Praktikum 7 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // buat sebuah frame
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 640);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // frame.setVisible(true);

        // buat objek JPanel
        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        frame.setVisible(true);
    }
}
