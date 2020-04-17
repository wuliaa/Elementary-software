package com;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @author  Inn
 * @version 1.0
 * @since   2020-04-10
 */


public class Staff extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	ImageIcon i1=new ImageIcon("src/image/four.png");
	ImageIcon i2=new ImageIcon("src/image/eight.png");
	String Exception;//双缓冲的异常
	int x,y;//鼠标的坐标
	boolean flag1=false,flag2=false,flag3=false;//按钮是否按下
	private Shape[] Array = new Shape[10000];
	String type="";//按钮上的字符
	int number = 0;//添加了几个音符
	Shape shape;
	Comparator<Shape> cmp = new MyComparator();//排序
	
	/**
	* 主类的构造函数
	* @param null
	* @return null
	*/
	
	Staff(){
		this.setTitle("Staff");//程序名字
		ImageIcon icon = new ImageIcon("src/image/icon.png");//程序图标
		Image image = icon.getImage();
		this.setIconImage(image);
		this.setSize(700,500);//窗口大小
		this.setBackground(Color.WHITE);
		Container contentPane = this.getContentPane();
		contentPane.setBackground(Color.white);//组件背景为白色
		// 北边面板
		JPanel panel1 = new JPanel(); 
        panel1.setBackground(Color.WHITE);
        panel1.setPreferredSize(new Dimension(120, 60));
        contentPane.add(panel1, BorderLayout.NORTH);
        //组件
        String[] str1 = { "♩", "♪", "▷"};
        Font f=new Font("Melody MakerDemo",Font.BOLD,20);//根据指定字体名称、样式和磅值大小
    	for (int i = 0; i < str1.length; i++) {
    		JButton button_1 = new JButton(str1[i]);
    		button_1.setFont(f);
    		panel1.add(button_1);
    		button_1.setPreferredSize(new Dimension(55, 50));//按钮大小
    		button_1.setContentAreaFilled(false);//中间不绘制
    		button_1.setFocusPainted(false);//交点框不绘制
    		Buttonaddlisten(button_1,i);//给按钮加上监听事件
    	}
    	addActionlistener(this);//鼠标移动和鼠标点击事件
    	this.setVisible(true);
		this.setLocationRelativeTo(null);//窗口位于屏幕中央
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭程序
		
	}
	
	/**
	* 鼠标的移动和监听事件，使用MouseAdapter
	* 主类不用继承三个监听的端口、不用重写许多不用的鼠标事件函数
	* @param a Staff类对象
	* @return nothing 
	*/
	public void addActionlistener(Staff a) {
		a.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				x=e.getX();
				y=e.getY();
				if(flag1||flag2||flag3)
					repaint();//重绘
			}
		});
		a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(type.equals("")) {}
				if (type.equals("♩")) {
					shape = new QuarterNote(x,y);
					if(Canput(y))
						if (number < Array.length) {
							Array[number++] = shape;// 将图形对象存入到数组
							flag1=false;
						}
				}
				if (type.equals("♪")) {
					shape = new EighthNote(x,y);
					if(Canput(y))
						if (number < Array.length) {
							Array[number++] = shape;// 将图形对象存入到数组
							flag2=false;
						}
				}
			}
		});
	}
	
	/**
	* 按钮的监听事件
	* 鼠标移入时按钮边框高亮
	* 点击按钮控制当前图形
	* @param b 按钮
	* @param i 第几个按钮
	* @return nothing
	*/
	public void Buttonaddlisten(JButton b,int i) {
		b.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				b.setBorder(BorderFactory.createLineBorder(Color.blue));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b.setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		});
		b.addActionListener((e)->{
			if(i==0) {flag1=true;flag2=flag3=false;}
			if(i==1) {flag2=true;flag1=flag3=false;}
			if(i==2) {
				flag3=true;flag1=flag2=false;
				Shape[] sortArray = new Shape[number];
				for (int j = 0; j < number; j++) {
		     		Shape shape = Array[j];
		     		if(shape!=null) {
		     			sortArray[j]=shape;
		     		}
		     	}
				Arrays.sort(sortArray,cmp);// 对数组排序，Arrays.sort方法不允许数组内有空值
				//否则报错NullPointerException
				Playmusic(sortArray);
			}
			type=b.getText();
		});//lambda表达式化简
	}
	
	
	/**
	* 判断音符可不可以放下
	* @param y 音符的纵坐标
	* @return boolean 
	*/
	public boolean Canput(int y) {
		int count1=0,count2=0,count3=0,count4=0;
		int count5=0,count6=0,count7=0,count8=0;
		for (int j = 0; j < number; j++) {
     		Shape shape = Array[j];
     		if(shape!=null&&(shape instanceof QuarterNote)) {
     			if(shape.getX()>50&&shape.getX()<=195)count1++;
     			if(shape.getX()>195&&shape.getX()<=340)count2++;
     			if(shape.getX()>340&&shape.getX()<=485)count3++;
     			if(shape.getX()>485&&shape.getX()<=630)count4++;
     		}
     		if(shape!=null&&(shape instanceof EighthNote)) {
     			if(shape.getX()>50&&shape.getX()<=195)count5++;
     			if(shape.getX()>195&&shape.getX()<=340)count6++;
     			if(shape.getX()>340&&shape.getX()<=485)count7++;
     			if(shape.getX()>485&&shape.getX()<=630)count8++;
     		}
     		if(Countnum(count1,count5)&&(x>50&&x<=195))return false;
     		if(Countnum(count2,count6)&&(x>195&&x<=340))return false;
 			if(Countnum(count3,count7)&&(x>340&&x<=485))return false;
 			if(Countnum(count4,count8)&&(x>485&&x<=630))return false;
     	}
		for(int i=220;i<=280;i+=5) {
			if(y==i) {return true;}
		}
		return false;
	}
	
	/**
	* 判断每一小节音符可不可以放下
	* 以四分音符为一拍，每小节有四拍
	* @param a 四分音符的个数
	* @param b 八分音符的个数
	* @return boolean 
	*/
	public boolean Countnum(int a,int b) {
		if(a==0&&b==8)return true;
		if(a==1&&b==6)return true;
		if(a==2&&b==4)return true;
		if(a==3&&b==2)return true;
		if(a==4&&b==0)return true;
		return false;
	}
	
	
	/**
	* 跑五线谱，播放音频
	* @param s 排好序的Shape数组
	* @return nothing
	*/
	@SuppressWarnings("static-access")
	public void Playmusic(Shape[] s){
		for(int i=0;i<number;i++) {
			Shape shape = s[i];
     		if(shape!=null) {
     			try{
     				if(i==0)
     					Thread.currentThread().sleep((shape.getX()-50)/40*1000);
     				else Thread.currentThread().sleep((shape.getX()-s[i-1].getX())/20*1000);
     			}catch(InterruptedException e){
     				e.printStackTrace();
     			}
     			if(shape instanceof QuarterNote)
     				MusicPlayer.DistinguishFour(shape.getY());
     			if(shape instanceof EighthNote)
     				MusicPlayer.DistinguishEight(shape.getY());
     		}
		}
	}
	
	
	/**
	* 绘图函数，回调，双缓冲绘图
	* @param g 画笔
	* @return nothing
	*/
	public void paint(Graphics g){
		super.paint(g);//一定要继承组件才能被正确渲染，否则很神奇
		//双缓冲绘图
		Image offScreenImage = this.createImage(WIDTH, HEIGHT);
		Graphics gImage =offScreenImage.getGraphics();
		gImage.setColor(gImage.getColor());
		gImage.fillRect(0,0,WIDTH,HEIGHT);
		
		//画五线谱
		drawStaff(g);
		
		//随鼠标移动的音符
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1.0f));//变回细的
		if(flag1) {
        	g.drawImage(i1.getImage(), x-7, y-30, null);
        	if(Canput(y)) {
        		g.drawImage(i1.getImage(), x-7, y-30,Color.cyan, null);
        		if(y==220||y==280)
        			g2.drawLine(x-10,y,x+10,y);//上加一间和下加一间
        	}
        }
        if(flag2) {
        	g.drawImage(i2.getImage(), x-16, y-37, null);
        	if(Canput(y)) {
        		g.drawImage(i2.getImage(), x-16, y-37,Color.cyan, null);
        		if(y==220||y==280)
        			g2.drawLine(x-10,y,x+10,y);
        	}
        }
        
        //双缓冲
		super.paint(gImage);
		try {
			Thread.sleep(200);//设置为200，闪烁不会太严重，但有一点延迟
		}catch(Exception e) {
			Exception.toString();
		}
		gImage.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	/**
	* 画五线谱
	* @param g 画笔
	* @return nothing
	*/
	public void drawStaff(Graphics g) {
		g.setFont(new Font("Melody MakerDemo",Font.PLAIN,25));//上网下载了音符字体
        g.drawString("4", 85, 250);//44拍
        g.drawString("4", 85, 270);
        for(int i=230;i<=270;i+=10)//五线
        	g.drawLine(50,i, 635, i);
        for(int i=210;i<635;i+=145)
        	g.drawLine(i, 230, i, 270);
        Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
		g2.setStroke(new BasicStroke(3.0f));//变粗
        g2.drawLine(50, 230, 50,270);//竖线
        g2.drawLine(635, 230, 635,270);
        Image image = Toolkit.getDefaultToolkit().getImage("src/image/high.png");
        image.getScaledInstance(25,60,10);
        g2.drawImage(image, 55, 223, 25, 60, this);//贴高音音符
        
        // 循环遍历Array数组
     	for (int i = 0; i < Array.length; i++) {
     		Shape shape = Array[i];// 从数组中获取Shape对象
     		if(shape!=null) {//shape是否不为空，如果不为空则调用画图的方法
     			shape.draw((Graphics2D)g);//调用绘制图的方法
     		}
     	}
	}

	/**
	* 主函数
	* @param args Unused.
	* @return nothing
	*/
	public static void main(String[] args) {
		new Staff();
	}
}