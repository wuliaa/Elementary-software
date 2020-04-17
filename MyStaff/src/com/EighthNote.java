package com;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
/*
 * @author  Inn
 * @version 1.0
 * ∞À∑÷“Ù∑˚¿‡
 */

public class EighthNote extends Shape{
	ImageIcon ii=new ImageIcon("src/image/eight.png");
	public EighthNote(int x,int y) {
		super(x,y);
		
	}
	public void draw(Graphics2D g){
		g.drawImage(ii.getImage(), getX()-16, getY()-37, null);
	}
}
