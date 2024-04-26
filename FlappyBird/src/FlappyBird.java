/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Latihan Praktikum 7 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int frameWidth = 360;
    int frameHeight = 640;

    // image attributes
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    // player
    int playerStartPosX = frameWidth / 8;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;

    // pipes attributes
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = -400;
    int pipeWidth = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes;

    // game logic
    Timer pipesCooldown;
    Timer gameLoop;
    int gravity = 1;
    boolean gameRunning = true;
    int score = 0;
    JLabel scoreLabel;
    JLabel gameOverLabel;

    // constructor
    public FlappyBird(){
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        addKeyListener(this);

        // load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        pipesCooldown = new Timer(1500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                placePipes();
            }
        });
        pipesCooldown.start();

        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setBounds(10, 10, 100, 30);
        add(scoreLabel);

        gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setForeground(Color.WHITE);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gameOverLabel.setBounds(80, frameHeight / 2 - 40, 200, 80);
        gameOverLabel.setVisible(false);
        add(gameOverLabel);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        for(int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }
    }

    public void move() {
        if (!gameRunning)
            return;

        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        for(int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());

            if (player.collidesWith(pipe)) {
                gameOver();
                return;
            }

            if (pipe.getPosX() + pipe.getWidth() < 0) {
                pipes.remove(pipe);
                if (!pipe.passed && pipe.getImage() == lowerPipeImage) {
                    pipe.passed = true;
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
            }
        }

        if (player.getPosY() + player.getHeight() > frameHeight) {
            gameOver();
        }
    }

    public void placePipes(){
        int randomPipePosY = (int) (pipeStartPosY - pipeHeight/4 - Math.random() + (pipeHeight/2));
        int openingSpace = frameHeight/4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPipePosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, randomPipePosY + pipeHeight + openingSpace, pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    public void gameOver() {
        gameRunning = false;
        pipesCooldown.stop();
        gameLoop.stop();
        gameOverLabel.setVisible(true);
    }

    public void restartGame() {
        pipes.clear();
        player.setPosY(playerStartPosY);
        gameRunning = true;
        score = 0;
        scoreLabel.setText("Score: " + score);
        gameOverLabel.setVisible(false);
        pipesCooldown.start();
        gameLoop.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            player.setVelocityY(-10);
        }

        if (!gameRunning && e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}