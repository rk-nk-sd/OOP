package game;

import game.units.*;
import game.units.common.BaseHero;
import game.base.GameBoard;
import game.units.common.Heroes;

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
//        worldWar.fire();

        System.out.println("----------------------");
        BaseHero lancer = new Lancer("Копейщик", new Point(0));
        BaseHero robber = new Robber("Разбойник", new Point(0,9));
        BaseHero aliaceLancer = new Monk("Медик",new Point());
        BaseHero arbalester = new Arbalester("Стрелок", new Point());
        BaseHero farmer = new Farmer("Фермер", new Point());

        System.out.printf("%s %s%s", lancer.getInfo(), lancer.getPoint(), System.lineSeparator());
        System.out.printf("%s %s%s", robber.getInfo(), robber.getPoint(), System.lineSeparator());

        lancer.setTeam("Tora");
        lancer.setAllias(List.of("Troya"));

        aliaceLancer.setTeam("Tora");
        aliaceLancer.setAllias(List.of("Troya"));

        farmer.setTeam("Troya");
        farmer.setAllias(List.of("Tora"));

        arbalester.setTeam("Troya");
        arbalester.setAllias(List.of("Tora"));

        robber.setTeam("MongoloTatarskoeIgo");
        robber.setAllias(List.of("Sparta"));

        System.out.println(lancer.checkDistance(robber));

        worldWar = new GameBoard(List.of(lancer, robber, aliaceLancer,farmer,arbalester));

        aliaceLancer.setPoint(0,7);

        arbalester.setPoint(9,0);
        farmer.setPoint(5,5);
        worldWar.view();


        while (true){
            try {
                List<BaseHero> heroes = new ArrayList<>(worldWar.getListHeroes());
                heroes.sort((o1, o2) -> Heroes.valueOf(o2.getClass().getSimpleName()).getSpeed()
                        - Heroes.valueOf(o1.getClass().getSimpleName()).getSpeed());
                for (BaseHero hero : heroes) {
                    hero.step(worldWar.getListHeroes());
                }
                worldWar.view();
            } catch (RuntimeException e) {
                worldWar.view();
                System.out.println(e.getMessage());
                return;
            }
        }
    }
}
