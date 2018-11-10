package pl.threedcrafts.cardGameGen;

public class HealCard extends Card {

    public void useCard(Player playerone, Player playertwo){
        playerone.lifePoint+=this.strongnest;

    }

    public HealCard(int costMoney, int strongnest, String name, String type) {
        super(costMoney, strongnest, name, type);
    }
}
