package Patalanocarlo;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        Faker faker = new Faker();


        List<String> champions = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            String champion = faker.leagueOfLegends().champion();
            champions.add(champion);
        }


        List<String> femaleMidChampions = new ArrayList<>();


        Random random = new Random();
        while (femaleMidChampions.size() < 10) {
            String champion = faker.leagueOfLegends().champion();
            if (isFemaleMidLaneChampion(champion)) {
                femaleMidChampions.add(champion);
            }
        }


        System.out.println("Champions: " + String.join(", ", champions));
        System.out.println("Female Mid Lane Champions: " + String.join(", ", femaleMidChampions));
    }


    private static boolean isFemaleMidLaneChampion(String champion) {
        return List.of("Ahri", "Akali", "Anivia", "Annie", "Cassiopeia", "Diana", "Irelia",
                "LeBlanc", "Lissandra", "Lux", "Neeko", "Orianna", "Qiyana",
                "Syndra", "Taliyah", "Zoe").contains(champion);
    }
}