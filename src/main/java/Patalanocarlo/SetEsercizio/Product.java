package Patalanocarlo.SetEsercizio;

public class Product { //Inizializziamo la classe Product con i 4 valori richiesti:
    Long id;
    String name;
    String category;
    double price;

    public Product ( Long id , String name , String category , double price){ //Da qui li passo come parametri a Product e vado ad assegnare il loro valore.
        this.id=id;
        this.name=name;
        this.category=category;
        this.price=price;
    }
    public Long getid(){ //Faccio i relativi getter e setter sulle istanze dei valori collegati perche poi mi serviranno nel Main
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String toString() { //Con il toString vado a stringifizzare in stringa:
        return "Prodotti :{id=" + id + " "  + "name=" + name + ""  + ", category='" + category + " " + ", price=" + price + '}';
    } // passo l'id il nome cateogria e prezzo dei prodotti...
}
