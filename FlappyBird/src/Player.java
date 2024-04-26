/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Latihan Praktikum 7 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

import java.awt.*;

public class Player {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Image image;
    private int velocityY;

    public Player(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        this.velocityY = -0;
    }

    public boolean collidesWith(Pipe pipe) {
        Rectangle playerRect = new Rectangle(posX, posY, width, height);
        Rectangle pipeRect = new Rectangle(pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight());
        return playerRect.intersects(pipeRect);
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int heigth){
        this.height = heigth;
    }
    public void setImage(Image image){
        this.image = image;
    }
    public void setVelocityY(int velocityY){
        this.velocityY = velocityY;
    }

    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public Image getImage(){
        return this.image;
    }
    public int getVelocityY(){
        return this.velocityY;
    }
}