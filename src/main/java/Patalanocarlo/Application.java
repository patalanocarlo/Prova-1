package Patalanocarlo;

import Patalanocarlo.SetEsercizio.Customer;
import Patalanocarlo.SetEsercizio.Order;
import Patalanocarlo.SetEsercizio.Product;
import com.github.javafaker.Faker;

import java.util.List;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
 //Esercizio 1
        List<Product> productList = new ArrayList<>();
        Faker faker = new Faker();
        Product prodotto_1 = new Product(244L, faker.commerce().productName(), faker.commerce().department(), 3401.45);
        Product prodotto_2 = new Product(21325L, faker.commerce().productName(), faker.commerce().department(), 140.95);
        Product prodotto_3 = new Product(219523L, faker.commerce().productName(), faker.commerce().department(), 1240);

        Customer customer_1 = new Customer(22553L, faker.leagueOfLegends().champion(), 1);
        Customer customer_2 = new Customer(22553L, faker.leagueOfLegends().champion(), 2);
        Customer customer_3 = new Customer(22553L, faker.leagueOfLegends().champion(), 2);


        Order ordine_1 = new Order(1L, "In attesa", LocalDate.now(), LocalDate.now().plusDays(2), Arrays.asList(prodotto_1, prodotto_3), customer_1);
        Order ordine_2 = new Order(2L, "Consegnato", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), Arrays.asList(prodotto_2), customer_2);
        Order order_3 = new Order(3L, "In transito", LocalDate.now().minusDays(1), LocalDate.now().plusDays(3), Arrays.asList(prodotto_1), customer_3);
        Order order_4 = new Order(4L, "Consegnato", LocalDate.now().minusDays(3), LocalDate.now().minusDays(1), Arrays.asList(prodotto_1, prodotto_2), customer_1);


        List<Order> ordini = Arrays.asList(order_4, order_3, ordine_2, ordine_1);
        Map<String, List<Order>> OrdiniDeiClienti = ordini.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getName()));

        for (Map.Entry<String, List<Order>> entry : OrdiniDeiClienti.entrySet()) { //vado a prendere ogni elemento del Map del ordine dei clienti
            System.out.println("Cliente: " + entry.getKey());//Mi vado a prendere la key del cliente in questo caso è il nome e stampo
            for (Order order : entry.getValue()) { //Qui invece con l'ordine vado ad iterare su ogni ordine associato al get vaòlue che sarebbe il cliente in questione.
                System.out.println("Ordine: " + order);
            } //Mi restituira quindi la lista del ordine del cliente in questione.
        }
//Fine esercizio 1
        //Esercizio 2
        Map<String, Double> VenditeAiClienti = ordini.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getName(), //Prendo e creo una collezione degli ordini in base al parametro dei Clienti cioè il nome
                        Collectors.summingDouble(order -> order.getProducts().stream()  //Ora per ogni ordine associato ad un cliente vado ad eeffettuare una somma.
                                .mapToDouble(Product::getPrice)  //Ora mi vado a prendere il prezzo dei singoli prodotti mappato dalla collezione del cliente
                                .sum()))); //sommo.

        for (String customer : VenditeAiClienti.keySet()) { //passando sempre come jeyset il nome del cliente ottengo iterando su ogni ordine cliente
            double VenditeTotali = VenditeAiClienti.get(customer); //il rapporto di prezzo venduto ad ogni customer cioe cliente
            System.out.println("Cliente: " + customer + " Totale Vendite: " + VenditeTotali);
        }
        //Fine esercizio 2
//Esercizio 3
        productList.add(prodotto_1);
        productList.add(prodotto_2);
        productList.add(prodotto_3);


        Product mostExpensiveProduct = productList.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);

        if (mostExpensiveProduct != null) {
            System.out.println("Prodotto più costoso: " + mostExpensiveProduct.getName());
        }
//Fine esercizio 3
        //Esercizio 4

        // Calcola la media degli importi degli ordini
        double MediaImporto = ordini.stream()
                .mapToDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                        .sum()) // Somma gli importi di tutti i prodotti in ciascun ordine
                .average() // Calcolo la media degli importi
                .orElse(0.0); // altrimenti mi da 0

        System.out.println("Media degli importi degli ordini: " + MediaImporto);
//Fine esercizio 4
//Esercizio 5

        // Raggruppa i prodotti per categoria e calcola la somma degli importi per ogni categoria
        Map<String, Double> SommaDellaCategoria= productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, // Raggruppa per categoria
                        Collectors.summingDouble(Product::getPrice))); // Calcola la somma degli importi per ogni categoria

        // Stampare i risultati
       SommaDellaCategoria.forEach((category, summingDuouble) ->
                System.out.println("Categoria: " + category + ", Totale Importi:" + summingDuouble));
       //Fine esercizio 5
    }

    }




