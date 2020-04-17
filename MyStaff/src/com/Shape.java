package com;
import java.awt.Graphics2D;
/*
 * @author  Inn
 * @version 1.0
 * �����࣬���������ķ������Ͱ˷�����
 */

public abstract class Shape {
	private int x,y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * ����ͼ�εķ���
	 * 
	 * @param g���ʶ���
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
