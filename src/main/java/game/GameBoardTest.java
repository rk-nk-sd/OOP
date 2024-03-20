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

        BaseHero heroFromIgo1 = new Sniper();
        heroFromIgo1.setTeam("MongoloTatarskoeIgo");
        heroFromIgo1.setAllias(Arrays.asList("Sparta", "Persy"));

        BaseHero heroFromIgo2 = new Arbalester();
        heroFromIgo2.setTeam("MongoloTatarskoeIgo");
        heroFromIgo2.setAllias(List.of("Sparta"));

        BaseHero heroFromSparta = new Monk();
        heroFromSparta.setTeam("Tora");
        heroFromSparta.setAllias(List.of("Troya"));

        List<BaseHero> listHeroes = List.of(heroFromIgo, heroFromSparta, heroFromIgo1, heroFromIgo2);
        GameBoard worldWar = new GameBoard(listHeroes);
        worldWar.fire();
    }
}
