package game;

import game.units.Arbalester;
import game.units.Monk;
import game.units.Sniper;
import game.units.common.BaseHero;
import game.base.GameBoard;

import java.util.*;

public class GameBoardTest {
    public static void main(String[] args) {
        BaseHero heroFromIgo = new Monk();
        heroFromIgo.setTeam("MongoloTatarskoeIgo");
        heroFromIgo.setAllias(Arrays.asList("Sparta", "Persy"));
        System.out.println(heroFromIgo.getInfo());

        BaseHero heroFromIgo1 = new Sniper();
        heroFromIgo1.setTeam("MongoloTatarskoeIgo");
        heroFromIgo1.setAllias(Arrays.asList("Sparta", "Persy"));
        System.out.println(heroFromIgo1.getInfo());

        BaseHero heroFromIgo2 = new Arbalester();
        heroFromIgo2.setTeam("MongoloTatarskoeIgo");
        heroFromIgo2.setAllias(List.of("Sparta"));
        System.out.println(heroFromIgo2.getInfo());

        BaseHero heroFromSparta = new Monk();
        heroFromSparta.setTeam("Tora");
        heroFromSparta.setAllias(List.of("Troya"));
        System.out.println(heroFromSparta.getInfo());


        new GameBoard(List.of(heroFromIgo, heroFromSparta, heroFromIgo1, heroFromIgo2));
    }
}
