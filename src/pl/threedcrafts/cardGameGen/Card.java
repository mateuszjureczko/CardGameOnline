package pl.threedcrafts.cardGameGen;



public class Card {

    int costMoney;
    int strongnest;
    String name;
    String type;
    public void useCard(Player playerone, Player playertwo){
    }

    public Card(int costMoney, int strongnest, String name, String type) {
        this.costMoney = costMoney;
        this.strongnest = strongnest;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
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

        return "Karta: "+name+" "+lvl+"  \ntyp: "+type+" \nkoszt: "+costMoney+"\nsila: "+strongnest+"\n\n";

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

        return "Karta: "+name+" "+lvl+"  <br>typ: "+type+" <br>koszt: "+costMoney+"\nsila: "+strongnest+"<br>";
    }
}
