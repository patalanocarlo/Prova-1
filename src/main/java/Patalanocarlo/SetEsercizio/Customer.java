package Patalanocarlo.SetEsercizio;

public class Customer { //Qui ho settato Customer
    Long id;
    String name;
    Integer tier;

    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }
    public Integer getTier(){ //Getter del Tier per lesercizio4 dove devo confrontare il Tier.
        return tier;
    }

}