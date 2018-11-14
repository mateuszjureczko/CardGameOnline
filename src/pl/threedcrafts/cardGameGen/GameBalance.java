package pl.threedcrafts.cardGameGen;

import java.util.HashMap;
import java.util.Map;

public class GameBalance {


    private Map<CardType, Integer>
            probalityOfType = new HashMap<CardType, Integer>();
    private Map<Integer, Integer> probablyOfStrong = new HashMap<Integer, Integer>();
    //elem can has 1-10 of Strong
    //probability is 1-10
    public Map<CardType, Integer> getProbalityOfType() {
        return probalityOfType;
    }

    public Map<Integer, Integer> getProbablyOfStrong() {
        return probablyOfStrong;
    }



    public GameBalance() {
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

    }

}
