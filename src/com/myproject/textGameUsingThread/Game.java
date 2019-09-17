package com.myproject.textGameUsingThread;

import java.util.Scanner;

public class Game {
	
	Scanner sc = new Scanner(System.in);
	Scanner entersc = new Scanner(System.in);
	String playerID;
	int choice;
	Music introMusic = new Music(true);
	Loading loading = new Loading("");
	Skill skill = new Skill(this);	
	Town town = new Town(this);
	Field field = new Field(this);
	Status status = new Status(this);
	Player player = new Player();
	
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
		System.out.println("경험치 : " + player.getXp());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("\n무엇을 하시겠습니까 ?\n");
		System.out.println("1.탐험하기");
		System.out.println("2.마을가기");
		System.out.println("3.캐릭터 상태창");
		System.out.println("4.스킬");
	
		choice = sc.nextInt();
	
		if(choice == 1) {
			field.start();	
		}
		else if(choice == 2) {
			town.start();
		}
		else if(choice == 3) {
			status.start();
		}
		else if(choice == 4) {
			 skill.start();
		}
		else {
			System.out.println("\n다시 입력해주세요\n");
			mainMenu();
		}
	}
}
