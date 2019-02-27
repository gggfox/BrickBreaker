/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author antoniomejorado
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage sprites; // to store the sprites 
    public static BufferedImage player;     // pictures for player
    public static BufferedImage playerUp[];     // pictures to go up
    public static BufferedImage playerLeft[];     // pictures to go left
    public static BufferedImage playerRight[];     // pictures to go right
    public static BufferedImage playerDown[];     // pictures to go down
    public static BufferedImage bad;
    public static SoundClip bomb;
    /**
     * initializing the images of the game
     */
    public static void init() {
        //imagen conseguida de:
        //"https://elperfilmenoshumano.com/2013/10/27/reflexiones-sobre-breaking-bad-2008-2013/breaking_bad_css3_svg_raw/"
        background = ImageLoader.loadImage("/images/breaking_bad_logo.png");
        player = ImageLoader.loadImage("/images/van.png");
        bad = ImageLoader.loadImage("/images/malo.png");
        bomb = new SoundClip("/sounds/goddamnit.wav");
        sprites = ImageLoader.loadImage("/images/professor.png");
        SpriteSheet spritesheet = new SpriteSheet(sprites);
        playerUp = new BufferedImage[9];
        playerLeft = new BufferedImage[9];
        playerDown = new BufferedImage[9];
        playerRight = new BufferedImage[9];
        
        for (int i = 0; i<9; i++){
            playerUp[i] = spritesheet.crop(i*64,20,64,64);
            playerLeft[i] = spritesheet.crop(i*64,84,64,64);
            playerDown[i] = spritesheet.crop(i*64,148,64,64);
            playerRight[i] = spritesheet.crop(i*64,212,64,64);
        }
    }
    
}
