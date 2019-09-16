package com.myproject.textGameUsingThread;

import java.util.Random;
import java.util.Scanner;

import com.myproject.textGameUsingThread2.Monster;
import com.myproject.textGameUsingThread2.Orc;
import com.myproject.textGameUsingThread2.Slime;
import com.myproject.textGameUsingThread2.Zombie;

public class Field {
	
	Game game;
	Player player = new Player();
	Monster monster;
	Scanner sc = new Scanner(System.in);
	String choice;
	Random rand = new Random();
	int potionChance;
	
	public Field(Game g) {
		game = g;
	}

	public void start() {

		System.out.println("\n어디로 가시겠습니까?\n");
		System.out.println("\n1.슬라임 사냥터");
		System.out.println("\n2.오크 사냥터");
		System.out.println("\n3.좀비 사냥터");
		System.out.println("\n4.메인 메뉴");
		
		choice = sc.nextLine();
		
		switch(choice) {
		case "1":
			slime(); break;
		case "2":
			orc(); break;
		case "3":
			zombie(); break;
		case "4":
			game.mainMenu();
		default:
			System.out.println("다시 입력해주세요");
			start();
			}
	}
	public void slime() {
		monster = new Slime();
		System.out.println("\n슬라임 사냥터 입장");
		System.out.println(monster.name + " : " + monster.attackMessage + "\n");
		System.out.println("체력 : " + monster.hp);
		System.out.println("공격력 : " + monster.damage);
		System.out.println("방어력 : " + monster.defence);
		System.out.println("처치시 획득 골드 : 100 " );
		//System.out.println("\n슬라임의 미끌거림은 상대방의 방어력을 낮춥니다");
		//player.setDefence(player.getDefence() - 2);
		//System.out.println("현재 방어력 : " + player.getDefence());
		select();
	}

	public void orc() {
		monster = new Orc();
		System.out.println("\n오크 사냥터 입장");
		System.out.println(monster.name + " : " + monster.attackMessage + "\n");
		System.out.println("체력 : " + monster.hp);
		System.out.println("공격력 : " + monster.damage);
		System.out.println("방어력 : " + monster.defence);
		System.out.println("처치시 획득 골드 : 150 " );
		//System.out.println("\n오크의 함성은 상대방의 공격력을 낮춥니다");
		//player.setDamage(player.getDamage() - 3);
		//System.out.println("현재 공격력 : " + player.getDamage());
		select();
	}
	public void zombie() {
		monster = new Zombie();
		System.out.println("\n좀비 사냥터 입장");
		System.out.println(monster.name + " : " + monster.attackMessage + "\n");
		System.out.println("체력 : " + monster.hp);
		System.out.println("공격력 : " + monster.damage);
		System.out.println("방어력 : " + monster.defence);
		System.out.println("처치시 획득 골드 : 200 " );
		//System.out.println("\n좀비의 울부짖음은 상대방의 체력을 낮춥니다");
		//player.setHp(player.getHp() - 10);
		//System.out.println("현재 생명 : " + player.getHp());
		select();
	}
	public void select() {
		System.out.println("\n1.공격   2.힐링포션   3.도망가기");
		choice = sc.nextLine();
		
		switch(choice) {
		case "1":
			playerAttack(); break;
		case "2":
			healing(); break;
		case "3":
			recovery(); break;
		default:
			System.out.println("다시 입력해주세요");
			select();
		}
	}
	public void playerAttack() {
		int playerAttack;
		playerAttack = rand.nextInt(player.getDamage()) + 10;
		if(monster.hp > 0) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println(game.playerID + "의 공격 ! " + playerAttack + " 데미지 !");
			monster.hp = (monster.hp - playerAttack) + monster.defence;
			System.out.println(monster.name + " 에 " + (playerAttack - monster.defence) + "의 피해를 입혔습니다");
			System.out.println(monster.name + " 체력 : " + monster.hp);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");	
			monsterAttack();
		}
		else if (monster.hp < 1){
			win();
		}
	}
	public void monsterAttack() {
		int monsterAttack;
		monsterAttack = rand.nextInt(monster.damage) + 10;
		if(player.getHp() > 0) {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");	
		System.out.println(monster.name + "의 공격 ! " + monsterAttack + " 데미지 !");
		player.setHp((player.getHp() - monsterAttack) + player.getDefence());
		System.out.println(game.playerID + "님이 " + (monsterAttack - player.getDefence()) + "의 피해를 입었습니다" );
		System.out.println(game.playerID + "님의 체력 : " + player.getHp());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");	
		select();
		}
		else if(player.getHp() < 1){
			lose();
		}
	}
	public void healing() {
		System.out.println("\n현재 포션 갯수 : " + player.getNumPotions());
		System.out.println("1.포션 사용   2.돌아가기");
		choice = sc.nextLine();
		switch(choice) {
		case "1":
			if(player.getNumPotions() > 0 && player.getHp() < player.getMaxHP()) {
				player.setHp(player.getHp() + 15);
				player.setNumPotions(player.getNumPotions() - 1);
				System.out.println("체력 15 회복. 현재 체력 : " + player.getHp());
				healing();
			} else {
				System.out.println("포션 갯수가 부족하거나 생명력이 가득찼습니다");
				select();
			}
			break;
		case "2":
			select(); break;
		}

	}
	public void recovery() {
		start();
	}
	public void lose() {
		System.out.println("----------GAME OVER----------");
	}
	public void win() {
		potionChance = rand.nextInt(100);
		System.out.println("\n----------- " + monster.name + " 처치 -----------\n"); 
		System.out.println("골드 : " + monster.gold + " 획득 / "+ "경험치 : " + monster.xp + " 획득");
		player.setGold(player.getGold() + monster.gold);
		player.setXp(player.getXp() + monster.xp);
		System.out.println("현재 골드 : " + player.getGold() + " / 현재 경험치 : " + player.getXp() + "\n");
		if(potionChance > 50) {
			player.setNumPotions(player.getNumPotions() + 1);
			System.out.println("포션 1개를 획득했습니다 ! 현재 포션 갯수 : " + player.getNumPotions() );
		}
		checkLevel();
	}
	public void checkLevel() {
		if(player.getXp() >= 100 && player.getLevel() == 1) {
			player.setLevel(player.getLevel() + 1);
			player.setMaxHP(player.getMaxHP() + 20);
			player.setDamage(player.getDamage() + 10);
			player.setDefence(player.getDefence() + 2);
			player.setSkillPoint(player.getSkillPoint() + 3);
			System.out.println("\n레벨업 !!\n현재 레벨 : " + player.getLevel());
			System.out.println("체력 20 증가 / 현재 체력 : " + player.getHp() + " / " + player.getMaxHP());
			System.out.println("공격력 10 증가 / 현재 공격력 : " + player.getDamage());
			System.out.println("방어력 2증가 / 현재 방어력 : " + player.getDefence());
			System.out.println("스킬포인트 3 추가 / 현재 스킬포인트 갯수 : " + player.getSkillPoint() + "\n\n");
			start();
		}
		else if (player.getXp() >= 300 && player.getLevel() == 2) {
			player.setLevel(player.getLevel() + 1);
			player.setMaxHP(player.getMaxHP() + 20);
			player.setDamage(player.getDamage() + 10);
			player.setDefence(player.getDefence() + 2);
			player.setSkillPoint(player.getSkillPoint() + 3);
			System.out.println("\n레벨업 !!\n현재 레벨 : " + player.getLevel());
			System.out.println("체력 20 증가 / 현재 체력 : " + player.getHp() + " / 풀 체력 : " + player.getMaxHP());
			System.out.println("공격력 10 증가 / 현재 공격력 : " + player.getDamage());
			System.out.println("방어력 2증가 / 현재 방어력 : " + player.getDefence());
			System.out.println("스킬포인트 3 추가 / 현재 스킬포인트 갯수 : " + player.getSkillPoint() + "\n\n");
			start();
		}
		else {
			start();
		}
	}
}
