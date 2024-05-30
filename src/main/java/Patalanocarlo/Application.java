package Patalanocarlo;

import Patalanocarlo.SetEsercizio.Product;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
Faker faker= new Faker();
        Product prodotto_1= new Product(244L,faker.commerce().productName(),faker.commerce().department(),faker.number().randomDouble(2, 10, 1000));
        Product prodotto_2= new Product(21325L,faker.commerce().productName(),faker.commerce().department(),faker.number().randomDouble(2, 10, 1000));
        Product prodotto_2= new Product(219523L,faker.commerce().productName(),faker.commerce().department(),faker.number().randomDouble(2, 10, 1000));
    }
}