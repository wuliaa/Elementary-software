package com;
import java.awt.Graphics2D;
/*
 * @author  Inn
 * @version 1.0
 * 抽象类，可派生出四分音符和八分音符
 */

public abstract class Shape {
	private int x,y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	public abstract void draw(Graphics2D g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
