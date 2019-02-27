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
    
    private Animation animationUp;
    private Animation animationLeft;
    private Animation animationRight;
    private Animation animationDown;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.velocity = 5;
        
        this.animationUp = new Animation(Assets.playerUp, 100);
        this.animationLeft = new Animation(Assets.playerLeft, 100);
        this.animationRight = new Animation(Assets.playerRight, 100);
        this.animationDown = new Animation(Assets.playerDown, 100);
    }
    
    public int getSpeed(){
        return velocity;
    }
    
    public void setSpeed(int velocity){
        this.velocity = velocity;
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
        this.animationRight.tick();

        if (game.getKeyManager().left) {
           setX(getX() - getSpeed() );
        }
        if (game.getKeyManager().right) {
           setX(getX() + getSpeed() );
        }
        // reset x position and y position if colision
        if (getX() + 150 >= game.getWidth()) {
            setX(game.getWidth() - 150);
        }
        else if (getX() <= -10) {
            setX(-10);
        }
    }
    
    public Rectangle getPerimetro() {

        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean intersecta(Object obj) {
        return obj instanceof Bad && getPerimetro().intersects(((Bad) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(animationRight.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
}