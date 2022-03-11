package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	final private String name;

	private Suit(String nm) {
		name = nm;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
