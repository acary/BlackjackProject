package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	List<Card> cards = new ArrayList<>();

	public BlackjackHand() {
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackjack() {
		int target = 21;
		if (getHandValue() == target) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		int target = 21;
		if (getHandValue() > target) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String output = "";
		for (Card card : cards) {
			output += card.toString();
		}
		return output;
	}

}
