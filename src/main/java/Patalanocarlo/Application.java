package Patalanocarlo;

import Patalanocarlo.SetEsercizio.Customer;
import Patalanocarlo.SetEsercizio.Order;
import Patalanocarlo.SetEsercizio.Product;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Product prodotto_1= new Product(244L,faker.commerce().productName(),faker.commerce().department(),faker.number().randomDouble(2, 10, 1000));
        Product prodotto_2= new Product(21325L,faker.commerce().productName(),faker.commerce().department(),faker.number().randomDouble(2, 10, 1000));
        Product prodotto_3= new Product(219523L,faker.commerce().productName(),faker.commerce().department(),faker.number().randomDouble(2, 10, 1000));

        Customer customer_1= new Customer(22553L,faker.leagueOfLegends().champion(),1);
        Customer customer_2= new Customer(22553L,faker.leagueOfLegends().champion(),2);
        Customer customer_3= new Customer(22553L,faker.leagueOfLegends().champion(),2);


        Order ordine_1 = new Order(1L, "In attesa", LocalDate.now(), LocalDate.now().plusDays(2), Arrays.asList(prodotto_1,prodotto_3), customer_1);
        Order ordine_2 = new Order(2L, "Consegnato", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), Arrays.asList(prodotto_2), customer_2);
        Order order_3 = new Order(3L, "In transito", LocalDate.now().minusDays(1), LocalDate.now().plusDays(3), Arrays.asList(prodotto_1), customer_3);
        Order order_4 = new Order(4L, "Consegnato", LocalDate.now().minusDays(3), LocalDate.now().minusDays(1), Arrays.asList(prodotto_1,prodotto_2), customer_1);



        List<Order> ordini= Arrays.asList(order_4,order_3,ordine_2,ordine_1);
        Map<String, List<Order>  > OrdiniDeiClienti=ordini.stream()
                .collect(Collectors.groupingBy(order ->order.getCustomer().getName() ));

        for (Map.Entry<String, List<Order>> entry : OrdiniDeiClienti.entrySet()) {
            System.out.println("Cliente: "+ entry.getKey());
            for (Order order: entry.getValue()){
                System.out.println("Ordine: " + order);}
        }
    }
}
