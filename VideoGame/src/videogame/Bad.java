/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author antoniomejorado
 */
public class Bad extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    
    public Bad(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.direction = -1;
    }

    /**
     * 
     * @return 
     */
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void tick() {
        setX(getX() + this.getDirection());
        // reset x position and y position if colision
//        if (getX() + 60 >= game.getWidth()) {
//            setX(game.getWidth() - 60);
//        }
//        else 
        if (getX() <= -30) {
            setX(-30);
        }
//        if (getY() + 80 >= game.getHeight()) {
//            setY(game.getHeight() - 80);
//        }
        else if (getY() <= -20) {
            setY(-20);
        }
    }

    public Rectangle getPerimetro() {

        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bad, getX(), getY(), getWidth(), getHeight(), null);
    }
}
