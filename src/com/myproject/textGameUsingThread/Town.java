package com.myproject.textGameUsingThread;

import java.util.Scanner;

public class Town {

	Game game;
	Player player = new Player();
	Scanner choice = new Scanner(System.in);
	String where;
	boolean longsword = false;
	boolean mithrill = false;
	
	public Town(Game g) {
		game = g;
	}
	public void start() {

		System.out.println("\n어디를 들리시겠습니까?\n");
		System.out.println("1.상점");
		System.out.println("2.치료소");
		System.out.println("3.메인메뉴");
		
		where = choice.nextLine();
		
		switch(where) {
		case "1":
			store(); break;
		case "2":
			recovery(); break;
		case "3":
			 game.mainMenu(); break;
		default:
			System.out.println("다시 입력해주세요");
			}
		}
	public void store() {		
		System.out.println("\n무기와 갑옷을 살 수 있습니다.\n");
		System.out.println("1.롱소드 : 300골드");
		System.out.println("2.미스릴갑옷 :200골드");
		System.out.println("3.뒤로");
		where = choice.nextLine();
		switch(where) {
		case "1": 
			longsword = true;
			player.setGold(player.getGold() - 300);
			player.setDamage(player.getDamage() + 3);
			System.out.println("롱소드 구매. 공격력 +3. 골드 : " + player.getGold());
			System.out.println("현재 공격력 : " + player.getDamage() + "\n");
			store();
			break;
		case "2":
			mithrill = true;
			player.setGold(player.getGold() - 300);
			player.setDefence(player.getDefence() + 3);
			System.out.println("미스릴갑옷 구매. 방어력 +3. 골드 : " + player.getGold());
			System.out.println("현재 방어력 : " + player.getDefence() + "\n");
			store();
			break;
		case"3":
			start(); break;	
		default:
			System.out.println("다시 입력해주세요");
			store();
		}
	}
	public void recovery() {
		if (player.getHp() < player.getMaxHP() ) {
			player.setHp(player.getHp() + 10);
			player.setGold(player.getGold() - 50);
			System.out.println("체력 10 회복. 현재 HP : " + player.getHp() + " 골드 : " + player.getGold());	
			start();
		}
		else {
			System.out.println("체력이 가득찼습니다");
			start();
		}
	}

	
}
