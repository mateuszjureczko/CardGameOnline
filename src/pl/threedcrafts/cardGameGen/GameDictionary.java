package pl.threedcrafts.cardGameGen;

import java.util.ArrayList;
import java.util.List;

public class GameDictionary {


    private List<Noun> nounListHeal = new ArrayList<Noun>();
    private List<String> adjectiveListHealPrefix = new ArrayList<String>();
    private List<String> adjectiveListHealSuffix = new ArrayList<String>();


    private List<Noun> nounListAttack = new ArrayList<Noun>();
    private List<String> adjectiveListAttackPrefix = new ArrayList<String>();
    private List<String> adjectiveListAttackSuffix = new ArrayList<String>();

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

    public GameDictionary(){


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
}
