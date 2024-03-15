package game;

import game.units.*;
import game.units.common.BaseHero;
import game.units.common.Heroes;

import java.util.ArrayList;
import java.util.List;

public class GameGetAllUnitsApp {
    public static void main(String[] args) {
        ArrayList<BaseHero> listHeroes = new ArrayList<>();
        listHeroes.add(new Arbalester());
        listHeroes.add(new Farmer());
        listHeroes.add(new Lancer());
        listHeroes.add(new Magician());
        listHeroes.add(new Monk());
        listHeroes.add(new Priest());
        listHeroes.add(new Robber());
        listHeroes.add(new Sniper());
//
//        List<String> heroesInfoName = listHeroes.stream().map(hero -> hero.getClass().getSimpleName()).collect(Collectors.toList());
//        List<String> heroesInfo = listHeroes.stream().map(hero -> hero.getInfo()).collect(Collectors.toList());
//        System.out.println(heroesInfo);

        List<BaseHero> listHeros1 = new ArrayList<>();
        listHeros1.add(new Arbalester());

        listHeros1.get(0).step(listHeroes);
        System.out.println(((Arbalester)listHeros1.get(0)).getArrows());

        listHeroes.sort((o1, o2) -> Heroes.valueOf(o2.getClass().getSimpleName()).getSpeed()
                - Heroes.valueOf(o1.getClass().getSimpleName()).getSpeed());

        listHeroes.forEach(n -> System.out.println(n.getInfo()));

    }
}
