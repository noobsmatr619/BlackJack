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

public enum CardTypeEnum {
   CLUBS ("Clubs"),
   DIAMONDS("Diamonds"),
   HEARTS("Hearts"),
   SPADES("Spades");
   
   private final String cardTypeText;
   
   private CardTypeEnum (String CardTypeText){
   this.cardTypeText=CardTypeText;
           
           }
   
   
   public String returnCardType(){
   return cardTypeText;
   }
   
   
}