package pl.threedcrafts.cardGameGen;

public class nounType {
    String name;
    Type type;


    public nounType(){};

    public nounType(String name, Type type) {

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}


