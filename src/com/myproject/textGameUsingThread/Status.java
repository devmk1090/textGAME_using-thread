package com.myproject.textGameUsingThread;

import java.util.Scanner;

public class Status {

	Game game;
	Player player = new Player();
	Scanner sc = new Scanner(System.in);
	int choice;
	
	public Status(Game g) {
		game = g;
	}
	
	public void start() {
		
		System.out.println("\n현재 " + game.playerID + " 의 상태\n");
		System.out.println("레벨 : "+ player.getLevel());
		System.out.println("체력 : " + player.getHp());
		System.out.println("경험치 : " + player.getXp());
		System.out.println("공격력 : " + player.getDamage());
		System.out.println("방어력 : " + player.getDefence());
		System.out.println("포션 : " + player.getNumPotions() + " 개");
		System.out.println("스킬포인트 : " + player.getSkillPoint());
		System.out.println("\n1.돌아가기");
	
		choice = sc.nextInt();
		
		if(choice == 1) {
			game.mainMenu();
		}
		else {
			System.out.println("\n다시 입력해주세요\n");
			start();
		}
	}
}
