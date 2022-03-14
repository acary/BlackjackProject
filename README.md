# Blackjack Project

### Description

This application is a single-player game of Blackjack.

After the initial hand is dealt, the player chooses to `hit` or `stay`.

- If the player hand equals `21`, the player wins.
- If the player hand exceeds `21`, the player busts and loses.

#### Soft Ace
- If the player draws an Ace that would otherwise cause them to bust, the `soft Ace` value is used (`1` versus `11`)

The player with the highest score without busting wins.

##### Running the program:
```
- Import project into Eclipse
- Compile and run main in `BlackjackApp.java`
```

### Classes

- `BlackjackApp`: runs the game
- `BlackjackHand`: extends `Hand`
	- Has methods to check `isBlackjack` and `isBust`
- `Hand`: abstract class with list for current hand
- `Deck`: list containing 52 cards simulating real deck
- `Card`: object holding suit and rank
- `Suit`: enumeration for four suits (♠ ♡ ♣ ♢)
- `Rank`: enumeration for card values (2-11)

### Lessons Learned

- Object-Oriented Programming (OOP) helps to model the real-world in code
- Classes can use Objects as fields
- Abstract classes can be extended by subclasses with specialized methods
- Collections help organize data and allow for fast search and retrieval
- Enumerations help control allowable data and provide additional information

### Technologies Used

- JavaSE-1.8
  - Abstract classes and methods
  - Collections; List, ArrayList
  - Enumerations
- Eclipse IDE

### Author

- Andy Cary (@acary)
