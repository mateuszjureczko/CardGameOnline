package pl.threedcrafts.cardGameGen;

public class AdjectiveType {
    String male;
    String feminine;
    String unremarkable;

    public String getVariatedAdjective(Noun type){
        if(type.getType()==NounType.FEMININE){
            return this.getFeminine();
        }
        if(type.getType()==NounType.MALE){
            return this.getMale();
        }
        if(type.getType()==NounType.UNREMARKABLE){
            return this.getUnremarkable();
        }
        return null;
    }


    public String getMale() {
        return male;
    }
    public String getFeminine() {
        return feminine;
    }
    public String getUnremarkable() {
        return unremarkable;
    }


}


