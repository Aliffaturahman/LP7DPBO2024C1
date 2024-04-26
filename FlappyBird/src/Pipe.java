/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Latihan Praktikum 7 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

import java.awt.*;

public class Pipe {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Image image;
    private int velocityX;
    boolean passed = false;

    public Pipe(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        this.velocityX = -5;
        this.passed = false;
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

    public void setHeight(int height){
        this.height = height;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public void setVelocityX(int velocityX){
        this.velocityX = velocityX;
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

    public int getVelocityX(){
        return this.velocityX;
    }
}