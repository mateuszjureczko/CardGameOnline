package pl.threedcrafts.cardGameGen;

public class AdjectiveType {
    String male;
    String feminine;
    String unremarkable;

    public String getVariatedAdjective(nounType type){
        if(type.getType()==Type.FEMININE){
            return this.getFeminine();
        }
        if(type.getType()==Type.MALE){
            return this.getMale();
        }
        if(type.getType()==Type.UNREMARKABLE){
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


