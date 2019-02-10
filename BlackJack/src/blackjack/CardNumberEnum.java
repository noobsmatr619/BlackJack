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
public enum CardNumberEnum {
   TWO ("2"),
   THREE ("3"),
   FOUR ("4"),
   FIVE ("5"),
   SIX ("6"),
   SEVEN ("7"),
   EIGHT ("8"),
   NINE ("9"),
   TEN ("10"),
   KING ("KING"),
   QUEEN ("QUEEN"),
   JACK  ("JACK"),
   ACE ("ACE");
   
   
    private final String cardNumberText;
   
   private CardNumberEnum (String CardTypeText){
   this.cardNumberText=CardTypeText;
           
           }
   
   
   public String returnCardNumber(){
   return cardNumberText;
   }
}
