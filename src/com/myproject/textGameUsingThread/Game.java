package com.myproject.textGameUsingThread;

import java.util.Scanner;

public class Game {
	
	Scanner sc = new Scanner(System.in);
	Scanner entersc = new Scanner(System.in);
	String playerID;
	String choice;
	Music introMusic = new Music(true);
	Loading loading = new Loading("");
	Skill skill = new Skill(this);	
	Town town = new Town(this);
	Field field = new Field(this);
	Player player = new Player();
	Gamble gamble;
	
	public Game() {
	}
	public void title() {		
		//introMusic.start();
		loading.start();
		try {
			loading.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("아이디를 입력하세요 : ");
		playerID = sc.nextLine();
		System.out.println("\n당신의 아이디는 " + playerID + " 입니다.\n");

		mainMenu();
	
	}
	public void mainMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("레벨 : "+ player.getLevel());
		System.out.println("체력 : " + player.getHp() + " / " + player.getMaxHP());
		System.out.println("공격력 : " + player.getDamage() + " / " + "방어력 : " + player.getDefence());
		System.out.println("포션 : " + player.getNumPotions() + " 개" + " / " + "스킬포인트 : " + player.getSkillPoint());
		System.out.println("경험치 : " + player.getXp() + " / 골드 : " + player.getGold());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("\n무엇을 하시겠습니까 ?\n");
		System.out.println("1.사냥터");
		System.out.println("2.룰렛(참가비 50골드)");
		System.out.println("3.마을");
		System.out.println("4.스킬");
		System.out.println("5.음악끄기");
	
		choice = sc.nextLine();
	
		switch(choice) {
		
		case "1":
			field.start(); break;
		case "2":
			player.setGold(player.getGold() - 50);
			gamble = new Gamble(this);
			gamble.running = true;
			gamble.start();
			break;
		case "3":
			town.start(); break;
		case "4":
			skill.start(); break;
		case "5":
			//introMusic.close();
			mainMenu(); break;
		default:
			mainMenu();
			break;
		}
	}

}
