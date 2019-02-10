/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 * need to add exception need to handle closing algorithm need to solve the problem with design patterns
 * @author Abrar Tajwar
 */
public class BlackJack {

   public static void main(String[] args){

		System.out.println("Welcome to Blackjack!");

		//playingDeck will be the deck the dealer holds
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffleDeck();

		//playerCards will be the cards the player has in their hand
		Deck playerCards = new Deck();
		//playerMoney holds players cash - we will be lazy and use doubles instead of bigdecimals
		double playerMoney = 100.0;
		//dealerCards will be the cards the dealer has in their hand
		Deck dealerCards = new Deck();

		//Scanner for user input
		Scanner userInput = new Scanner(System.in);

		//Play the game while the player has money
		//Game loop
while(playerMoney>0){
	//Take Bet
	System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
	double playerBet = userInput.nextDouble();
	boolean endRound = false;
	if(playerBet > playerMoney){
		//Break if they bet too much
		System.out.println("You cannot bet more than you have.");
		break;
	}

	System.out.println("Dealing...");
	//Player gets two cards
	playerCards.draw(playingDeck);
	playerCards.draw(playingDeck);

	//Dealer gets two cards
	dealerCards.draw(playingDeck);
	dealerCards.draw(playingDeck);

			//While loop for drawing new cards
			while(true)
			{
				//Display player cards
				System.out.println("Your Hand:" + playerCards.toString());

				//Display Value
				System.out.println("Your hand is currently valued at: " + playerCards.cardsNumber());

				//Display dealer cards
				System.out.println("Dealer Hand: " + dealerCards.cardGetter(0).toString() + " and [hidden]");

				//What do they want to do
				System.out.println("Would you like to (1)Hit or (2)Stand");
				int response = userInput.nextInt();
				//They hit
				if(response == 1){
					playerCards.draw(playingDeck);
					System.out.println("You draw a:" + playerCards.cardGetter(playerCards.deckSize()-1).toString());
					//Bust if they go over 21
					if(playerCards.cardsNumber() > 21){
						System.out.println("Bust. Currently valued at: " + playerCards.cardsNumber());
						playerMoney -= playerBet;
						endRound = true;
						break;
					}
				}

				//Stand
				if(response == 2){
					break;
				}

			}

			//Reveal Dealer Cards
			System.out.println("Dealer Cards:" + dealerCards.toString());
			//See if dealer has more points than player
			if((dealerCards.cardsNumber() > playerCards.cardsNumber())&&endRound == false){
				System.out.println("Dealer beats you " + dealerCards.cardsNumber() + " to " + playerCards.cardsNumber());
				playerMoney -= playerBet;
				endRound = true;
			}
			//Dealer hits at 16 stands at 17
			while((dealerCards.cardsNumber() < 17) && endRound == false){
				dealerCards.draw(playingDeck);
				System.out.println("Dealer draws: " + dealerCards.cardGetter(dealerCards.deckSize()-1).toString());
			}
			//Display value of dealer
			System.out.println("Dealers hand value: " + dealerCards.cardsNumber());
			//Determine if dealer busted
			if((dealerCards.cardsNumber()>21)&& endRound == false){
				System.out.println("Dealer Busts. You win!");
				playerMoney += playerBet;
				endRound = true;
			}
			//Determine if push
			if((dealerCards.cardsNumber() == playerCards.cardsNumber()) && endRound == false){
				System.out.println("Push.");
				endRound = true;
			}
			//Determine if player wins
			if((playerCards.cardsNumber() > dealerCards.cardsNumber()) && endRound == false){
				System.out.println("You win the hand.");
				playerMoney += playerBet;
				endRound = true;
			}
			else if(endRound == false) //dealer wins
			{
				System.out.println("Dealer wins.");
				playerMoney -= playerBet;
			}

			//End of hand - put cards back in deck
			playerCards.moveAllToDeck(playingDeck);
			dealerCards.moveAllToDeck(playingDeck);
			System.out.println("End of Hand.");

		}
		//Game is over
		System.out.println("Game over! You lost all your money. :(");

		//Close Scanner
		userInput.close();

	}

}