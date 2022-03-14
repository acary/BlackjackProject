package com.skilldistillery.cards.common;

public enum Rank {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10),
	ACE(11);

	// Removed `final` for soft Ace
	int value;

	private Rank(int val) {
		value = val;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int val) {
		this.value = val;
	}
}