package com.myproject.textGameUsingThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Surprise extends Thread {

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	String disp = sdf.format(date);
	
	public Surprise() {
		
	}
	
	@Override
	public void run() {
		
		int i = 0;
		while(true) {
			i++;			
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("희귀 몬스터를 발견했습니다!!");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			try {
				Thread.sleep(1000*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			

	}
}
