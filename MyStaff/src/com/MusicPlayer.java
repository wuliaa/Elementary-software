package com;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/*
 * @author  Inn
 * @version 1.0
 * ����wav��Ƶ��
 */

public class MusicPlayer {
	private static File file = null;
	//����audioclip����
	private static AudioClip audioClip = null;
	public static void play(String fileUrl) {
		//ѡ�񲥷��ļ�
		file = new File(fileUrl);
		
		//��fileת��Ϊurl
		try {
			audioClip = Applet.newAudioClip(file.toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����һ��ʹ��audioClip.play
		audioClip.play();
	}
	public static void stop() {
		audioClip.stop();
	}
	
	/**
	* ����y�жϲ����ĸ���Ƶ
	* @param y ������������
	* @return nothing
	*/
	public static void DistinguishFour(int y) {
		if(y==280) play("src/audio/Do_4.wav");
		else if(y==275) play("src/audio/Re_4.wav");
		else if(y==270) play("src/audio/Mi_4.wav");
		else if(y==265) play("src/audio/Fa_4.wav");
		else if(y==260) play("src/audio/So_4.wav");
		else if(y==255) play("src/audio/La_4.wav");
		else if(y==250) play("src/audio/Si_4.wav");
		else if(y==245) play("src/audio/Doi_4.wav");
		else if(y==240) play("src/audio/1_4.wav");
		else if(y==235) play("src/audio/2_4.wav");
		else if(y==230) play("src/audio/3_4.wav");
		else if(y==225) play("src/audio/4_4.wav");
		else if(y==220) play("src/audio/5_4.wav");
	}
	public static void DistinguishEight(int y) {
		if(y==280) play("src/audio/Do_8.wav");
		else if(y==275) play("src/audio/Re_8.wav");
		else if(y==270) play("src/audio/Mi_8.wav");
		else if(y==265) play("src/audio/Fa_8.wav");
		else if(y==260) play("src/audio/So_8.wav");
		else if(y==255) play("src/audio/La_8.wav");
		else if(y==250) play("src/audio/Si_8.wav");
		else if(y==245) play("src/audio/Doi_8.wav");
		else if(y==240) play("src/audio/1_8.wav");
		else if(y==235) play("src/audio/2_8.wav");
		else if(y==230) play("src/audio/3_8.wav");
		else if(y==225) play("src/audio/4_8.wav");
		else if(y==220) play("src/audio/5_8.wav");
	}

}
