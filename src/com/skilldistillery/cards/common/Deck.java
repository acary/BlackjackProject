package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();

	public Deck() {
		cards = initializeDeck();
	}

	private List<Card> initializeDeck() {
		List<Card> newDeck = new ArrayList<>(52);

		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		for (Suit s : suits) {
			for (Rank rank : ranks) {
				Card newCard = new Card(s, rank);
				newDeck.add(newCard);
			}
		}
		return newDeck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		Card draw;
		draw = cards.remove(0);
		return draw;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

}
