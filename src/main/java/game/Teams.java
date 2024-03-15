package game;

import game.units.common.BaseHero;
import game.units.Magician;
import game.units.Priest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams {
    public static void main(String[] args) {
        int teamCount = 10;
        Random rand = new Random();

        int magicianCount = 0;
        int priestCount = 0;

        List<BaseHero> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            if (rand.nextInt(2) == 0) {
                teams.add(new Priest());
                priestCount++;
            } else {
                teams.add(new Magician());
                magicianCount++;
            }
            System.out.println(teams.get(i).getInfo());
        }

        System.out.println();
        System.out.printf("magicianCount: %d priestCount: %d\n", magicianCount, priestCount);

//        int magicianCount = rand.nextInt(teamCount);
//        int priestCount = teamCount - magicianCount;
//
//        System.out.printf("magicianCount: %d priestCount: %d\n", magicianCount, priestCount);
//
//        Priest[] priests = new Priest[priestCount];
//        Magician[] magician = new Magician[magicianCount];
//
//        for (int i = 0; i < priestCount; i++) {
//            priests[i] = new Priest();
//            System.out.println(priests[i].getInfo());
//        }
//
//        for (int i = 0; i < magicianCount; i++) {
//            magician[i] = new Magician();
//            System.out.println(magician[i].getInfo());
//        }
    }
}
