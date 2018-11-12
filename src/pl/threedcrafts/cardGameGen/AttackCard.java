package pl.threedcrafts.cardGameGen;

public class AttackCard extends Card {


    public void useCard(Player playerone, Player playertwo){
        playertwo.lifePoint-=this.strongnest;

    }



    public AttackCard(int costMoney, int strongnest, String name, String type,ClassType cardForClassType) {
        super(costMoney, strongnest, name, CardType.ATTACK,cardForClassType);
    }
}
