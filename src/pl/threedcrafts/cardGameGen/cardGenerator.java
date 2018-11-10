package Card;

import com.sun.xml.internal.ws.util.xml.NamedNodeMapIterator;

import java.util.*;

public class cardGenerator {
    //those data could be change to database;
    private List<String> nounListHeal = new ArrayList<String>();
    private List<String> adjectiveListHealPrefix = new ArrayList<String>();
    private List<String> adjectiveListHealSuffix = new ArrayList<String>();


    private List<String> nounListAttack = new ArrayList<String>();
    private List<String> adjectiveListAttackPrefix = new ArrayList<String>();
    private List<String> adjectiveListAttackSuffix = new ArrayList<String>();

    private List<String> types = new ArrayList<String>();
    private Map<String, Integer> probalityOfType = new HashMap<String, Integer>();
    private Map<Integer, Integer> probablyOfStrong = new HashMap<Integer, Integer>();
    //elem can has 1-10 of Strong
    //probability is 1-10


    public List<String> getNounListHeal() {
        return nounListHeal;
    }

    public List<String> getAdjectiveListHealPrefix() {
        return adjectiveListHealPrefix;
    }

    public List<String> getAdjectiveListHealSuffix() {
        return adjectiveListHealSuffix;
    }

    public List<String> getNounListAttack() {
        return nounListAttack;
    }

    public List<String> getAdjectiveListAttackPrefix() {
        return adjectiveListAttackPrefix;
    }

    public List<String> getAdjectiveListAttackSuffix() {
        return adjectiveListAttackSuffix;
    }

    public List<String> getTypes() {
        return types;
    }

    public Map<String, Integer> getProbalityOfType() {
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
        probalityOfType.put("heal", 3);
        probalityOfType.put("attack", 10);
        probalityOfType.put("effect", 5);

        types.add("lecznicza");
        types.add("atakujaca");

        nounListAttack.add("topor");
        nounListAttack.add("miecz");
        nounListAttack.add("bicz");

        adjectiveListAttackPrefix.add("");
        adjectiveListAttackPrefix.add("siermiężny");
        adjectiveListAttackPrefix.add("ostateczny");
        adjectiveListAttackPrefix.add("legendarny");

        adjectiveListAttackSuffix.add("");
        adjectiveListAttackSuffix.add("ostatecznej zaglady");
        adjectiveListAttackSuffix.add("Andrzeja");
        adjectiveListAttackSuffix.add("potępienia");

        nounListHeal.add("kwiatek");
        nounListHeal.add("napój");
        nounListHeal.add("środek");
        nounListHeal.add("płyn");

        adjectiveListHealPrefix.add("");
        adjectiveListHealPrefix.add("leczniczy");
        adjectiveListHealPrefix.add("regenerujacy");
        adjectiveListHealPrefix.add("przecwibólowy");

        adjectiveListHealSuffix.add("");
        adjectiveListHealSuffix.add("z Radomia");
        adjectiveListHealSuffix.add("korzenny");
        adjectiveListHealSuffix.add("dodajacy otuchy");


    }


    private String getTheType() {
        Iterator<Map.Entry<String, Integer>> elem = getProbalityOfType().entrySet().iterator();
        Integer sumOfProbablies = 0;
      //  System.out.println(this.probalityOfType);
        while (elem.hasNext()) {
            Map.Entry<String, Integer> myElem = elem.next();
            sumOfProbablies += myElem.getValue();
        }


      //  System.out.println("suma to: "+sumOfProbablies);

        double tickets = Math.random() * sumOfProbablies;
       // System.out.println("wylosowana liczba:"+tickets);

        int sumOfTickets = 0;
        String strong = "";
       // System.out.println(this.probalityOfType);
        Iterator<Map.Entry<String, Integer>> itr = getProbalityOfType().entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> myElem = itr.next();
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

    private String getTheName(String type){
        Random rand = new Random();
        String suffix = new String("");
        String prefix =new String("");
        String name =new String("");
        switch(type){




            case "heal":
                 suffix = adjectiveListHealSuffix.get(rand.nextInt(adjectiveListHealSuffix.size()));
                 prefix = adjectiveListHealPrefix.get(rand.nextInt(adjectiveListHealPrefix.size()));
                 name = nounListHeal.get(rand.nextInt(nounListHeal.size()));
                break;

            case "attack":
                 suffix = adjectiveListAttackSuffix.get(rand.nextInt(adjectiveListAttackSuffix.size()));
                 prefix = adjectiveListAttackPrefix.get(rand.nextInt(adjectiveListAttackPrefix.size()));
                 name = nounListAttack.get(rand.nextInt(nounListAttack.size()));
                break;


        }

return prefix+" "+name+" "+suffix;

    }
    public List<Card> generate(Integer numberOfCards) {
        List<Card> deck = new ArrayList<Card>();

        for(int i=0; i<numberOfCards;i++){
            String type=getTheType();
            System.out.println(type);
            int strongnest = getTheStrongnest();
            String name = getTheName(type);
            //counting number of probality tickets
            int cost=(int)Math.floor((double) strongnest*0.7)+1;
            deck.add(new Card(cost,strongnest,name,type));
        }

        return deck;

    }


}