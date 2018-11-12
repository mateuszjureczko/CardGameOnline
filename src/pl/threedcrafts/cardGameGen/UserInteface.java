package pl.threedcrafts.cardGameGen;

import java.util.List;
import java.util.Scanner;

public class UserInteface {

    public static void chooseFirstCards(Player player, List<Card> deck){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<5; i++){
            System.out.println("choose card (1-10)");
            int cardNum = scanner.nextInt();
            System.out.println(cardNum);
            Card card = deck.get(cardNum-1);
            System.out.println("---------------\nchosen card: \n"+card+"\n\n--------------------");
            if(card.cardType==null){
                i--;
                System.out.println("choose proper card!");
            }else{
                player.addCard(card);
                deck.set(cardNum-1,new Card(0,0,null,null,null));
            }
        }
    }
}
