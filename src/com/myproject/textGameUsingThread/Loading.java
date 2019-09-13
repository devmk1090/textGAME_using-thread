package com.myproject.textGameUsingThread;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Loading extends Thread{
	
	Scanner entersc = new Scanner(System.in);
	int width = 150;
	int height = 30;
	String str;
	public Loading(String str) {
		this.str = str;
	}
	@Override
	public void run() {

		System.out.println("\n\n\n고독한 영웅의 여정이 시작된다");
		System.out.print("\nLoading : ");
		for(int i = 0; i < 70; i++) {
			System.out.print("■");

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for(int i = 0; i<50; i++) {
			System.out.println("");
		}
		
		//ASCII ART 
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setFont(new Font("Arial", Font.BOLD, 14));
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2D.drawString("MONSTER HUNTER", 10, 20);
		
		for (int y = 0; y < height; y++) {
		    StringBuilder stringBuilder = new StringBuilder();
		 
		    for (int x = 0; x < width; x++) {
		        stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ? "#" : "*");
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
		    }
		 
		    if (stringBuilder.toString().trim().isEmpty()) {
		        continue;
		    }
		 
		    System.out.println(stringBuilder);
		}
		System.out.println("\n시작하려면 ENTER 를 눌러주세요\n");
		entersc.nextLine();
		for(int i = 0; i<50; i++) {
			System.out.println("");
		}
	}	
}
