package pl.threedcrafts.cardGameGen;

public class Noun {
    String name;
    NounType type;


    public Noun(){};

    public Noun(String name, NounType type) {

        this.name = name;
        this.type = type;
        // can contain male , feminine, unremarkable
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NounType getType() {
        return type;
    }

    public void setType(NounType type) {
        this.type = type;
    }
}


