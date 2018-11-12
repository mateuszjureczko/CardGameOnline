package pl.threedcrafts.cardGameGen;



public class Card {

    int costMoney;

    int strongnest;
    String name;
    CardType cardType;
    ClassType cardForClassType;
    public void useCard(Player playerone, Player playertwo){
    }

    public Card(int costMoney, int strongnest, String name, CardType cardType,ClassType cardForClassType) {
        this.costMoney = costMoney;
        this.strongnest = strongnest;
        this.name = name;
        this.cardType = cardType;
        this.cardForClassType =  cardForClassType;
    }

    public int getCostMoney() {
        return costMoney;
    }

    public int getStrongnest() {
        return strongnest;
    }



    public String getName() {
        return name;
    }




    @Override
    public String toString() {
        String lvl;
        if(strongnest>8){
            lvl="(bardzo rzadki)";
        }else if(strongnest>5){

                lvl ="(rzadki)";
            }else{
            lvl="(zwykly)";
        }

        return "Karta: "+name+" "+lvl+"  \ntyp: "+cardForClassType.toString()+" \nkoszt: "+costMoney+"\nsila: "+strongnest+"\n\n";

    }

    public String toStringForHtml(){
        String lvl;
        if(strongnest>8){
            lvl="(bardzo rzadki)";
        }else if(strongnest>5){

            lvl ="(rzadki)";
        }else{
            lvl="(zwykly)";
        }

        return "Karta: "+name+" "+lvl+"  <br>typ: "+cardForClassType.toString()+" <br>koszt: "+costMoney+"\nsila: "+strongnest+"<br>";
    }
}
