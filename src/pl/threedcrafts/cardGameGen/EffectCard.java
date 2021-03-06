package pl.threedcrafts.cardGameGen;

public class EffectCard extends Card{
    int lifeUntilRound;
    int life;
    int cash;
    int ability;
    int health;

    public void useCard(Player playerone, Player playertwo,int round){
        playerone.lifePoint=(int) Math.floor(playerone.lifePoint+playerone.lifePoint*health);
        playerone.lifePoint=(int) Math.floor(playerone.abilityPoint+playerone.abilityPoint*ability);
        playerone.lifePoint=(int) Math.floor(playerone.cash+playerone.cash*cash);
        this.lifeUntilRound = round+life;
    }

    public EffectCard(int costMoney, int strongnest, String name, CardType type, ClassType cardForClassType, int lifeUntilRound, int life, int cash, int ability, int health) {
        super(costMoney, strongnest, name, type, cardForClassType);
        this.lifeUntilRound = lifeUntilRound;
        this.life = life;
        this.cash = cash;
        this.ability = ability;
        this.health = health;
    }
}
