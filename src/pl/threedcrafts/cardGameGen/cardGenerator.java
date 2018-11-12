package pl.threedcrafts.cardGameGen;

import com.sun.xml.internal.ws.util.xml.NamedNodeMapIterator;

import java.util.*;

public class cardGenerator {
    //those data could be change to database;
    private List<Noun> nounListHeal = new ArrayList<Noun>();
    private List<String> adjectiveListHealPrefix = new ArrayList<String>();
    private List<String> adjectiveListHealSuffix = new ArrayList<String>();


    private List<Noun> nounListAttack = new ArrayList<Noun>();
    private List<String> adjectiveListAttackPrefix = new ArrayList<String>();
    private List<String> adjectiveListAttackSuffix = new ArrayList<String>();


    private Map<CardType, Integer>
            probalityOfType = new HashMap<CardType, Integer>();
    private Map<Integer, Integer> probablyOfStrong = new HashMap<Integer, Integer>();
    //elem can has 1-10 of Strong
    //probability is 1-10


    public List<Noun> getNounListHeal() {
        return nounListHeal;
    }

    public List<String> getAdjectiveListHealPrefix() {
        return adjectiveListHealPrefix;
    }

    public List<String> getAdjectiveListHealSuffix() {
        return adjectiveListHealSuffix;
    }

    public List<Noun> getNounListAttack() {
        return nounListAttack;
    }

    public List<String> getAdjectiveListAttackPrefix() {
        return adjectiveListAttackPrefix;
    }

    public List<String> getAdjectiveListAttackSuffix() {
        return adjectiveListAttackSuffix;
    }



    public Map<CardType, Integer> getProbalityOfType() {
        return probalityOfType;
    }

    public Map<Integer, Integer> getProbablyOfStrong() {
        return probablyOfStrong;
    }


    public cardGenerator() {
    }

    public void prepareBase() {
        this.probablyOfStrong.put(1, 10);
        this.probablyOfStrong.put(2, 10);
        this.probablyOfStrong.put(3, 9);
        this.probablyOfStrong.put(4, 8);
        this.probablyOfStrong.put(5, 5);
        this.probablyOfStrong.put(6, 4);
        this.probablyOfStrong.put(7, 4);
        this.probablyOfStrong.put(8, 2);
        this.probablyOfStrong.put(9, 2);
        this.probablyOfStrong.put(10, 1);
        probalityOfType.put(CardType.HEAL, 3);
        probalityOfType.put(CardType.ATTACK, 10);
        probalityOfType.put(CardType.EFFECT, 5);

;


        nounListAttack.add(new Noun("Topor",NounType.MALE));
        nounListAttack.add(new Noun("miecz",NounType.MALE));
        nounListAttack.add(new Noun("bicz",NounType.MALE));


        adjectiveListAttackPrefix.add("");
        adjectiveListAttackPrefix.add("siermiężny");
        adjectiveListAttackPrefix.add("ostateczny");
        adjectiveListAttackPrefix.add("legendarny");

        adjectiveListAttackSuffix.add("");
        adjectiveListAttackSuffix.add("ostatecznej zaglady");
        adjectiveListAttackSuffix.add("Andrzeja");
        adjectiveListAttackSuffix.add("potępienia");

        nounListHeal.add(new Noun("kwiatek",NounType.FEMININE));
        nounListHeal.add(new Noun("napój",NounType.FEMININE));
        nounListHeal.add(new Noun("środek",NounType.FEMININE));
        nounListHeal.add(new Noun("płyn",NounType.FEMININE));


        adjectiveListHealPrefix.add("");
        adjectiveListHealPrefix.add("leczniczy");
        adjectiveListHealPrefix.add("regenerujacy");
        adjectiveListHealPrefix.add("przecwibólowy");

        adjectiveListHealSuffix.add("");
        adjectiveListHealSuffix.add("z Radomia");
        adjectiveListHealSuffix.add("korzenny");
        adjectiveListHealSuffix.add("dodajacy otuchy");


    }


    private CardType getTheType() {
        Iterator<Map.Entry<CardType, Integer>> elem = getProbalityOfType().entrySet().iterator();
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
        Iterator<Map.Entry<CardType, Integer>> itr = getProbalityOfType().entrySet().iterator();
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
        Iterator<Map.Entry<Integer, Integer>> elem = getProbablyOfStrong().entrySet().iterator();
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
        Iterator<Map.Entry<Integer, Integer>> iter = getProbablyOfStrong().entrySet().iterator();
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
            suffix = adjectiveListHealSuffix.get(rand.nextInt(adjectiveListHealSuffix.size()));
            prefix = adjectiveListHealPrefix.get(rand.nextInt(adjectiveListHealPrefix.size()));
            name = nounListHeal.get(rand.nextInt(nounListHeal.size()));
        }
        if(type.equals(CardType.HEAL)){
            suffix = adjectiveListAttackSuffix.get(rand.nextInt(adjectiveListAttackSuffix.size()));
            prefix = adjectiveListAttackPrefix.get(rand.nextInt(adjectiveListAttackPrefix.size()));
            name = nounListAttack.get(rand.nextInt(nounListAttack.size()));
        }
        if(type.equals(CardType.EFFECT)){
            suffix = "";
            prefix = "";
            name = nounListHeal.get(1);
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