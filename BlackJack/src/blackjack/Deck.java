/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Abrar Tajwar
 */
public class Deck {
    
	private ArrayList<Card> cards;
	
	public Deck(){
		//Create a new deck of playing cards
		this.cards = new ArrayList<Card>();
	
	}
	
	//Add 52 playing cards to a deck
	public void createFullDeck(){
		//Generate Cards
		//Loop Through Suits
		for(CardTypeEnum  cardType : CardTypeEnum .values()){
			//Loop through Values
			for(CardNumberEnum cardNumber : CardNumberEnum.values()){
				//Add new card to the mix
				this.cards.add(new Card(cardType,cardNumber));
			}
		}
	}
	
	
//Shuffle deck of cards
public void shuffleDeck(){
	//Create a new arraylist to hold the shuffled cards temporarily
	ArrayList<Card> tmpDeck = new ArrayList<Card>();
	//Randomly pick from the old deck and copy values to the new deck
	Random random = new Random();
	int randomCardShuffler = 0;
	int originalSize = this.cards.size();
	for(int i = 0; i<originalSize;i++){
		//gen random num according to int randomNum = rand.nextInt((max - min) + 1) + min;
		randomCardShuffler = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
		//throw random card into new deck
		tmpDeck.add(this.cards.get(randomCardShuffler));
		//remove picked from old deck
		this.cards.remove(randomCardShuffler);
	}
	//set this.deck to our newly shuffled deck
	this.cards = tmpDeck;
}
	
	
	
	//Get card from deck
	public Card cardGetter(int i){
		return this.cards.get(i);
	}
	
	//Add card to deck
	public void cardAdder(Card addCard){
		this.cards.add(addCard);
	}
        //Remove a card from the deck
	public void cardRemover(int i){
		this.cards.remove(i);
	}
    
	
	//Draw a top card from deck
	public void draw(Deck comingFrom){
		//Add card to this deck from whatever deck its coming from
		this.cards.add(comingFrom.cardGetter(0));
		//Remove the card in the deck its coming from
		comingFrom.cardRemover(0);
	}
	
	
	
	
	public void moveAllToDeck(Deck moveTo){
		int thisDeckSize = this.cards.size();
		//put cards in moveTo deck
		for(int i = 0; i < thisDeckSize; i++){
			moveTo.cardAdder(this.cardGetter(i));
		}
		//empty out the deck
		for(int i = 0; i < thisDeckSize; i++){
			this.cardRemover(0);
		}
	}
	
	public int deckSize(){
		return this.cards.size();
	}
	
	//Calculate the value of deck
	public int cardsNumber(){
		int totalValue = 0;
		int aces = 0;
		//For every card in the deck
		for(Card aCard : this.cards){
			//Switch of possible values
			switch(aCard.getValue()){
			case TWO: totalValue += 2; break;
			case THREE: totalValue += 3; break;
			case FOUR: totalValue += 4; break;
			case FIVE: totalValue += 5; break;
			case SIX: totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE: totalValue += 9; break;
			case TEN: totalValue += 10; break;
			case JACK: totalValue += 10; break;
			case QUEEN: totalValue += 10; break;
			case KING: totalValue += 10; break;
			case ACE: aces += 1; break;
			}			
		}
		
		//Determine the total current value with aces
		//Aces worth 11 or 1 - if 11 would go over 21 make it worth 1
		for(int i = 0; i < aces; i++){
			//If they're already at over 10 getting an ace valued at 11 would put them up to 22, so make ace worth one
			if (totalValue > 10){
				totalValue += 1;
			}
			else{
				totalValue += 11;
			}
		}
		
		//Return
		return totalValue;
    
}
        public String toString(){
		String cardListOutput = "";
		int i = 0;
		for(Card aCard : this.cards){
			cardListOutput += "\n" + aCard.toString();
			i++;
		}
		return cardListOutput;
	}
}
