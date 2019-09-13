package com.myproject.textGameUsingThread;

import java.util.Scanner;

public class Field {
	
	Player player = new Player();
	Scanner sc = new Scanner(System.in);
	String choice;
	
	public Field() {
		
	}

	public void start() {
		System.out.println("\n어디로 가시겠습니까?\n");
		System.out.println("\n1.슬라임 사냥터");
		System.out.println("\n2.오크 사냥터");
		System.out.println("\n3.좀비 사냥터");
		
		choice = sc.nextLine();
		
		switch(choice) {
		case "1":
			slime(); break;
		case "2":
			orc(); break;
		case "3":
			zombie(); break;
		default:
			System.out.println("다시 입력해주세요");
			start();
			}
	}
	public void slime() {
		System.out.println("\n슬라임 사냥터 입장\n");
		System.out.println("\n슬라임의 미끌거림은 상대방의 방어력을 낮춥니다\n");
		player.setDefence(player.getDefence() - 2);
		System.out.println("현재 방어력 : " + player.getDefence());
	}
	public void orc() {
		System.out.println("\n슬라임 사냥터 입장\n");
	}
	public void zombie() {
		
	}
}
