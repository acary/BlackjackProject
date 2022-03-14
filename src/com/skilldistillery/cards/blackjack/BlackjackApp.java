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
			
			// Deal house
			BlackjackHand house = new BlackjackHand();
			for (int i = 0; i < 2; i++) {
				Card newCard = deck.dealCard();
				
				// Check for soft Ace
				int newValue = newCard.getValue();
				if ((house.getHandValue()) + newValue > 21) {
					if (newValue == 11) {
						newCard.setValue(1);
					}
				}
				
				house.cards.add(newCard);
			}
			System.out.println("Dealer hand:");
			for (Card card : house.cards) {
				System.out.println("- " + card.toString() + " (" + card.getValue() + ")");
			}
			System.out.println("Dealer Total: " + house.getHandValue());
			System.out.println();

			// Deal player
			BlackjackHand hand = new BlackjackHand();
			for (int i = 0; i < 2; i++) {
				Card newCard = deck.dealCard();
				
				// Check for soft Ace
				int newValue = newCard.getValue();
				if ((hand.getHandValue()) + newValue > 21) {
					if (newValue == 11) {
						newCard.setValue(1);
					}
				}
				
				hand.cards.add(newCard);
			}

			System.out.println("Your hand:");
			for (Card card : hand.cards) {
				System.out.println("- " + card.toString() + " (" + card.getValue() + ")");
			}
			System.out.println("Your Total: " + hand.getHandValue());

			// Check result after first hand
			if (hand.isBlackjack()) {
				System.out.println("\n********************************");
				System.out.println("Blackjack! You win!");
				System.out.println("********************************");
				playing = false;
				break;
			} else if (hand.isBust()) {
				System.out.println("\n********************************");
				System.out.println("Busted! Dealer wins. Game over.");
				System.out.println("********************************");
				playing = false;
				break;
			}

			if (house.isBlackjack()) {
				System.out.println("\n********************************");
				System.out.println("Dealer wins with Blackjack.");
				System.out.println("********************************");
				playing = false;
				break;
			} else if (house.isBust()) {
				System.out.println("\n********************************");
				System.out.println("Dealer busted. You win! (" + hand.getHandValue() + ")");
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

						// Check for soft Ace
						int newValue = newCard.getValue();
						if ((hand.getHandValue()) + newValue > 21) {
							if (newValue == 11) {
								newCard.setValue(1);
							}
						}

						hand.cards.add(newCard);
						System.out.println("\nDraw:\n- " + newCard.toString() + " (" + newCard.getValue() + ")");
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
					house.cards.add(houseCard);
					System.out.println("- " + houseCard.toString() + " (" + houseCard.getValue() + ")");
					System.out.println("Dealer Total: " + house.getHandValue());

					// Check if both bust
					if (hand.isBust() && house.isBust()) {
						System.out.println("\n********************************");
						System.out.println("All Players Busted! No winner.");
						System.out.println("********************************");
						playing = false;
						break;
					}
					
					// Check player hand
					if (hand.isBlackjack()) {
						System.out.println("\n********************************");
						System.out.println("Blackjack! You win! (" + hand.getHandValue() + ")");
						System.out.println("********************************");
						playing = false;
						break;
					} else if (hand.isBust()) {
						System.out.println("\n********************************");
						System.out.println("Busted! Dealer wins. Game over.");
						System.out.println("********************************");
						playing = false;
						break;
					}

					// Check dealer hand
					if (house.isBlackjack()) {
						System.out.println("\n********************************");
						System.out.println("Dealer has Blackjack. House wins.");
						System.out.println("********************************");
						playing = false;
						break;
					} else if (house.isBust()) {
						System.out.println("\n********************************");
						System.out.println("Dealer busted. You win!");
						System.out.println("********************************");
						playing = false;
						break;
					}
				} else {
					System.out.println("\nDealer stays (" + house.getHandValue() + ")");

					// Check if both bust
					if (hand.isBust() && house.isBust()) {
						System.out.println("\n********************************");
						System.out.println("All Players Busted! No winner.");
						System.out.println("********************************");
						playing = false;
						break;
					}
					
					// Check player hand
					if (hand.isBlackjack()) {
						System.out.println("\n********************************");
						System.out.println("Blackjack! You win!");
						System.out.println("********************************");
						playing = false;
						break;
					} else if (hand.isBust()) {
						System.out.println("\n********************************");
						System.out.println("Busted! Dealer wins. Game over.");
						System.out.println("********************************");
						playing = false;
						break;
					}
				}

				// Check round result
				if (input.equalsIgnoreCase("stay")) {
					
					// Check if both bust
					if (hand.isBust() && house.isBust()) {
						System.out.println("\n********************************");
						System.out.println("All Players Busted! No winner.");
						System.out.println("********************************");
						playing = false;
						break;
					}
					
					// Compare hands
					if (hand.getHandValue() >= house.getHandValue()) {
						System.out.println("\n********************************");
						System.out.println("You win!" + " (" + hand.getHandValue() + ")");
						System.out.println("********************************");
						playing = false;
						break;
					} else {
						System.out.println("********************************");
						System.out.println("Dealer wins " + " (" + house.getHandValue() + ")");
						System.out.println("********************************");
						playing = false;
						break;
					}
				}
			}

		} while (playing);
	}

}
