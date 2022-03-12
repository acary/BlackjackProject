package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	static Scanner sc = new Scanner(System.in);

	public BlackjackApp() {
	}

	public static void main(String[] args) {
		System.out.println("********************************");
		System.out.println("**** Welcome to the Casino! ****");
		System.out.println("********************************");
		System.out.println();
		System.out.println("You are sitting at the Blackjack table.");

		boolean playing = true;
		do {
			String input = null;
			Deck deck = new Deck();
			deck.shuffle();

			System.out.println();
			BlackjackHand house = new BlackjackHand();
			for (int i = 0; i < 2; i++) {
				Card newCard = deck.dealCard();
				house.cards.add(newCard);
			}
			System.out.println("Dealer hand:");
			for (Card card : house.cards) {
				System.out.println("- " + card.toString());
			}
			System.out.println("Dealer Total: " + house.getHandValue());
			System.out.println();

			BlackjackHand hand = new BlackjackHand();
			for (int i = 0; i < 2; i++) {
				Card newCard = deck.dealCard();
				hand.cards.add(newCard);
			}

			System.out.println("Your hand:");
			for (Card card : hand.cards) {
				System.out.println("- " + card.toString());
			}
			System.out.println("Your Total: " + hand.getHandValue());

			// Check result after first hand
			if (hand.isBlackjack()) {
				System.out.println("\n********************************");
				System.out.println("Blackjack! You won!");
				System.out.println("********************************");
				playing = false;
				break;
			} else if (hand.isBust()) {
				System.out.println("\n********************************");
				System.out.println("Busted! Game over.");
				System.out.println("********************************");
				playing = false;
				break;
			}

			for (;;) {

				// Your turn
				try {
					System.out.println();
					System.out.println("Hit or Stay?");
					input = sc.next();
					if (input.equalsIgnoreCase("hit")) {
						Card newCard = deck.dealCard();
						hand.cards.add(newCard);
						System.out.println("\n- " + newCard.toString() + "\n");
						System.out.println("Your Total: " + hand.getHandValue());
					} else if (input.equalsIgnoreCase("stay")) {
						System.out.println("Staying.");
					}
				} catch (Exception e) {
					continue;
				}

				// Dealer turn
				if (house.getHandValue() < 17) {
					System.out.println("\nDealer hits.");
					Card houseCard = deck.dealCard();
					house.addCard(houseCard);
					System.out.println("\n- " + houseCard.toString());
					System.out.println("Dealer Total: " + house.getHandValue());

					// Check end game result
					if (hand.isBlackjack()) {
						System.out.println("\n********************************");
						System.out.println("Blackjack! You won!");
						System.out.println("********************************");
						playing = false;
						break;
					} else if (hand.isBust()) {
						System.out.println("********************************");
						System.out.println("Busted! Game over.");
						System.out.println("********************************");
						playing = false;
						break;
					}
				} else {
					System.out.println("\nDealer stays.");

					// Check end game result
					if (hand.isBlackjack()) {
						System.out.println("\n********************************");
						System.out.println("Blackjack! You won!");
						System.out.println("********************************");
						playing = false;
						break;
					} else if (hand.isBust()) {
						System.out.println("********************************");
						System.out.println("Busted! Game over.");
						System.out.println("********************************");
						playing = false;
						break;
					}
				}

				// Check round result
				if (input.equalsIgnoreCase("stay")) {
					if (hand.getHandValue() >= house.getHandValue()) {
						System.out.println("\n********************************");
						System.out.println("You win!");
						System.out.println("********************************");
						playing = false;
						break;
					} else {
						System.out.println("********************************");
						System.out.println("Dealer wins.");
						System.out.println("********************************");
						playing = false;
						break;
					}
				}
			}

		} while (playing);
	}

}
