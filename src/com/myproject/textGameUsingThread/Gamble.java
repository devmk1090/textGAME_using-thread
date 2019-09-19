package com.myproject.textGameUsingThread;

public class Gamble extends Thread {
	
	int chance;
	String choice;
	boolean running = false;
	Game game;
	
	public Gamble(Game g) {
		game = g;
	}
	
	@Override
	public void run() {
		while(running) {
			System.out.println("룰렛 돌리는중.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			chance = new java.util.Random().nextInt(100)+1;
			if(chance > 50) {
				running = false;
				unique();
			}
		}

		
		
	}
	public void unique() {
		chance = new java.util.Random().nextInt(100)+1;
		if(chance >= 90) {
		System.out.println("\n\n1등 당첨 !! 500골드 획득\n\n");
		Player.setGold(Player.getGold() + 500);
		game.mainMenu();
		} 
		else if (chance >= 80 && chance <90) {
			System.out.println("\n\n2등 당첨 !! 300골드 획득\n\n");
			Player.setGold(Player.getGold() + 300);
			game.mainMenu();
		}
		else if (chance >= 70 && chance < 80) {
			System.out.println("\n\n3등 당첨 !! 100골드 획득\n\n");
			Player.setGold(Player.getGold() + 100);
			game.mainMenu();
		}
		else {
			System.out.println("\n\n꽝 !!\n\n");
			game.mainMenu();
		}
	}
}
