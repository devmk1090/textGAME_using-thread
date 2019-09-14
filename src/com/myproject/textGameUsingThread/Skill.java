package com.myproject.textGameUsingThread;

import java.util.Scanner;


public class Skill{

	static Player player = new Player();
	String skillChoice;
	Scanner skill = new Scanner(System.in);
	Game game;

	public Skill(Game g) {
		game = g;
	}
	public void start() {
	
		System.out.println("\n스킬을 올려 강력해질 수 있습니다\n");
		System.out.println("현재 공격력 : " + player.getDamage());
		System.out.println("현재 방어력 : " + player.getDefence());
		System.out.println("현재 체력 : " + player.getHp() + " / " + player.getMaxHP());
		System.out.println("현재 스킬포인트 : " + player.getSkillPoint());
		System.out.println("\n1.공격력 증가\n2.방어력 증가\n3.체력 증가\n4.메인메뉴");
		
		skillChoice = skill.nextLine();
		
		switch(skillChoice) {
		case "1":
			attackDamage(); break;
		case "2":
			defence(); break;
		case "3":
			hp(); break;
		case "4":
			game.mainMenu(); break;
		default:
			System.out.println("다시 입력해주세요");
			start();
	}
}
	public void attackDamage() {
		if(player.getSkillPoint() > 0) {
		player.setDamage(player.getDamage()+3);
		player.setSkillPoint(player.getSkillPoint()-1);
		System.out.println("공격력 1 상승. 현재 공격력 : " + player.getDamage());
		System.out.println("남은 스킬 포인트 : " + player.getSkillPoint() + "\n");
		start();
		}
		else {
			System.out.println("스킬 포인트가 부족합니다\n");
			start();
		}
	}
	public void defence() {
		if(player.getSkillPoint() > 0) {
		player.setDefence(player.getDefence()+1);
		player.setSkillPoint(player.getSkillPoint()-1);
		System.out.println("방어력 1 상승. 현재 공격력 : " + player.getDamage());
		System.out.println("남은 스킬 포인트 : " + player.getSkillPoint() + "\n");
		start();
		}
		else {
			System.out.println("스킬 포인트가 부족합니다\n");
			start();
		}
	}
	public void hp() {
		if(player.getSkillPoint() > 0) {
		player.setMaxHP(player.getMaxHP() + 10);
		player.setSkillPoint(player.getSkillPoint()-1);
		System.out.println("체력 10 상승. 현재 체력 : " + player.getHp() + " / " + player.getMaxHP());
		System.out.println("남은 스킬 포인트 : " + player.getSkillPoint() + "\n");
		start();
		}
		else {
			System.out.println("스킬 포인트가 부족합니다\n");
			start();
		}
	}

}
