package game;

import game.units.*;
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

        BaseHero heroFromSparta1 = new Arbalester();
        heroFromSparta1.setTeam("Tora");
        heroFromSparta1.setAllias(List.of("Troya"));

        List<BaseHero> listHeroes = List.of(heroFromIgo, heroFromSparta, heroFromIgo1, heroFromIgo2, heroFromSparta1);
        GameBoard worldWar = new GameBoard(listHeroes);
        worldWar.fire();

        System.out.println("----------------------");
        BaseHero lancer = new Lancer("Копейщик", new Point(0));
        BaseHero robber = new Robber("Разбойник", new Point(0,9));
        BaseHero aliaceLancer = new Monk("Медик",new Point());

        System.out.printf("%s %s%s", lancer.getInfo(), lancer.getPoint(), System.lineSeparator());
        System.out.printf("%s %s%s", robber.getInfo(), robber.getPoint(), System.lineSeparator());

        lancer.setTeam("Tora");
        lancer.setAllias(List.of("Troya"));

        aliaceLancer.setTeam("Tora");
        aliaceLancer.setAllias(List.of("Troya"));

        robber.setTeam("MongoloTatarskoeIgo");
        robber.setAllias(List.of("Sparta"));

        System.out.println(lancer.checkDistance(robber));

        worldWar = new GameBoard(List.of(lancer, robber, aliaceLancer));

        aliaceLancer.getPoint().setPointX(0);
        aliaceLancer.getPoint().setPointY(7);

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();

        lancer.step(worldWar.getListHeroes());
        worldWar.view();



    }
}
