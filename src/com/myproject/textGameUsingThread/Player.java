package com.myproject.textGameUsingThread;

public class Player {
	private static int hp;
	private static int maxHP;
    private static int xp;
    private static int damage;
    private static int defence;
    private static int level;
    private static int numPotions;
    private static int skillPoint;
    private static int gold;
    
    public Player() {
    	hp = 80;
    	maxHP = 80;
    	xp = 0;
    	damage = 30;
    	defence = 2;
    	level = 1;
    	numPotions = 3;
    	skillPoint = 3;
    	gold = 200;
    }

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumPotions() {
		return numPotions;
	}

	public void setNumPotions(int numPotions) {
		this.numPotions = numPotions;
	}

	public int getSkillPoint() {
		return skillPoint;
	}

	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}

	public static int getGold() {
		return gold;
	}

	public static void setGold(int gold) {
		Player.gold = gold;
	}
}


