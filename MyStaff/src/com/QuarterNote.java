package com;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
/*
 * @author  Inn
 * @version 1.0
 * ËÄ·ÖÒô·ûÀà
 */

public class QuarterNote extends Shape{
	ImageIcon ii=new ImageIcon("src/image/four.png");
	public QuarterNote(int x,int y) {
		super(x,y);
		
	}
	public void draw(Graphics2D g){
		g.drawImage(ii.getImage(), getX()-7, getY()-30, null);
	}
}
