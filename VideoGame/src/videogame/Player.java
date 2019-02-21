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
public class Player extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int velocity;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.velocity = 5;
    }

    public int getDirection() {
        return direction;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void tick() {
        // moving player depending on flags
//        if (game.getMouseManager().isIzquierdo()) {
//            setX(game.getMouseManager().getX());
//            setY(game.getMouseManager().getY());
//            game.getMouseManager().setIzquierdo(false);
//        }
//        if (game.getKeyManager().up) {
//           setY(getY() - 1);
//        }
//        if (game.getKeyManager().down) {
//           setY(getY() + 1);
//        }
        if (game.getKeyManager().left) {
           setX(getX() - velocity);
        }
        if (game.getKeyManager().right) {
           setX(getX() + velocity);
        }
        // reset x position and y position if colision
        if (getX() + getWidth() >= game.getWidth()) {
            setX( game.getWidth() - getWidth() );
        }
         if (getX() <= 0 ) {
            setX(0);
        }
//        if (getY() + 80 >= game.getHeight()) {
//            setY(game.getHeight() - 80);
//        }
//        else if (getY() <= -20) {
//            setY(-20);
//        }
    }
    
    public Rectangle getPerimetro() {

        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean intersecta(Object obj) {
        return obj instanceof Bad && getPerimetro().intersects(((Bad) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
}
