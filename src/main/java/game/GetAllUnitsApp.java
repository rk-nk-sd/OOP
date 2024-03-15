package game;

import game.units.*;
import game.units.common.BaseHero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllUnitsApp {
    public static void main(String[] args) {
        List<BaseHero> listHeroes = new ArrayList<>();
        listHeroes.add(new Arbalester());
        listHeroes.add(new Farmer());
        listHeroes.add(new Lancer());
        listHeroes.add(new Magician());
        listHeroes.add(new Monk());
        listHeroes.add(new Priest());
        listHeroes.add(new Robber());
        listHeroes.add(new Sniper());

        List<String> heroesInfoName = listHeroes.stream().map(hero -> hero.getClass().getSimpleName()).collect(Collectors.toList());
        List<String> heroesInfo = listHeroes.stream().map(hero -> hero.getInfo()).collect(Collectors.toList());
        System.out.println(heroesInfo);

    }
}
