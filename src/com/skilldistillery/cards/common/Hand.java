package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	List<Card> cards = new ArrayList<>();

	public Hand() {
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	void clear() {
		cards = null;
	}

	public abstract int getHandValue();

	public String toString() {
		String output = "";
		for (Card card : cards) {
			output += card.toString();
		}
		return output;
	}

}
