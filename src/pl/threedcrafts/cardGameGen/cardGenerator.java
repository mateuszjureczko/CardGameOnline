package pl.threedcrafts.cardGameGen;

import com.sun.xml.internal.ws.util.xml.NamedNodeMapIterator;

import java.util.*;

public class cardGenerator {
    GameBalance balance = new GameBalance();
    GameDictionary dictionary = new GameDictionary();

    public cardGenerator() {
    }




    private CardType getTheType() {
        Iterator<Map.Entry<CardType, Integer>> elem = balance.getProbalityOfType().entrySet().iterator();
        Integer sumOfProbablies = 0;
      //  System.out.println(this.probalityOfType);
        while (elem.hasNext()) {
            Map.Entry<CardType, Integer> myElem = elem.next();
            sumOfProbablies += myElem.getValue();
        }


      //  System.out.println("suma to: "+sumOfProbablies);

        double tickets = Math.random() * sumOfProbablies;
       // System.out.println("wylosowana liczba:"+tickets);

        int sumOfTickets = 0;
        CardType strong = null;
        // System.out.println(this.probalityOfType);
        Iterator<Map.Entry<CardType, Integer>> itr = balance.getProbalityOfType().entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<CardType, Integer> myElem = itr.next();
            sumOfTickets += myElem.getValue();
            //System.out.println("suma: "+sumOfTickets);
            if (sumOfTickets > tickets) {
            //    System.out.println("weszlo wbnor to "+myElem.getKey());
                strong = myElem.getKey();
                break;
            }

        }
        return strong;

    }



    private int getTheStrongnest() {
        Iterator<Map.Entry<Integer, Integer>> elem = balance.getProbablyOfStrong().entrySet().iterator();
        Integer sumOfProbablies = 0;
      //  System.out.println(this.probablyOfStrong);
        while (elem.hasNext()) {
            Map.Entry<Integer, Integer> myElem = elem.next();
           // System.out.println("key: "+ myElem.getKey());
            //System.out.println("value: "+ myElem.getValue());
            sumOfProbablies += myElem.getValue();
        }

        double tickets = Math.random() * sumOfProbablies;
     //   System.out.println("ticketchoosed"+tickets);

        int sumOfTickets = 0;
        int strong = 0;
        Iterator<Map.Entry<Integer, Integer>> iter = balance.getProbablyOfStrong().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> myElem = iter.next();
            sumOfTickets += myElem.getValue();

            if (sumOfTickets > tickets) {

                strong = myElem.getKey();
                break;
            }

        }

        return strong;

    }

    private String getTheName(CardType type){
        Random rand = new Random();
        String suffix = new String("");
        String prefix =new String("");
        Noun name = new Noun();
        if(type.equals(CardType.ATTACK)){
            suffix = dictionary.getAdjectiveListHealSuffix().get(rand.nextInt(dictionary.getAdjectiveListHealSuffix().size()));
            prefix = dictionary.getAdjectiveListHealPrefix().get(rand.nextInt(dictionary.getAdjectiveListHealPrefix().size()));
            name = dictionary.getNounListHeal().get(rand.nextInt(dictionary.getNounListHeal().size()));
        }
        if(type.equals(CardType.HEAL)){
            suffix = dictionary.getAdjectiveListAttackSuffix().get(rand.nextInt(dictionary.getAdjectiveListAttackSuffix().size()));
            prefix = dictionary.getAdjectiveListAttackPrefix().get(rand.nextInt(dictionary.getAdjectiveListAttackPrefix().size()));
            name = dictionary.getNounListAttack().get(rand.nextInt(dictionary.getNounListAttack().size()));
        }
        if(type.equals(CardType.EFFECT)){
            suffix = "";
            prefix = "";
            name = dictionary.getNounListAttack().get(1);
        }





return prefix+" "+name.getName()+" "+suffix;

    }
    public List<Card> generate(Integer numberOfCards) {
        List<Card> deck = new ArrayList<Card>();

        for(int i=0; i<numberOfCards;i++){
            CardType type=getTheType();
            System.out.println(type);
            int strongnest = getTheStrongnest();
            String name = getTheName(type);
            //counting number of probality tickets
            int cost=(int)Math.floor((double) strongnest*0.7)+1;
            deck.add(new Card(cost,strongnest,name,type,ClassType.MAGICIAN));
        }

        return deck;

    }


}