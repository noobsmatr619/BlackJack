/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Abrar Tajwar
 */
public class Card {
    
	private CardTypeEnum  cardType;
	private CardNumberEnum value;
	
	public Card(CardTypeEnum   cardType, CardNumberEnum  value){
		this.cardType=  cardType;
		this.value = value;
	}
	
	public String toString(){
		return this.cardType.toString() + "-" + this.value.toString();
	}
	
	public CardNumberEnum getValue(){
		return this.value;
	}


}
