package com.skilldistillery.cards.common;

import java.util.Objects;

public class Card {

	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	public int getValue() {
		return this.rank.getValue();
	}
	
	// Added setter for soft Ace
	public void setValue(int val) {
		this.rank.value = val;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && Objects.equals(suit, other.suit);
	}



}
