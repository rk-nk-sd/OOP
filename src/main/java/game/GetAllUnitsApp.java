package game;

import game.units.*;
import game.units.common.BaseHero;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> heroesInfo = listHeroes.stream().map(BaseHero::getInfo).collect(Collectors.toList());
        System.out.println(heroesInfo);

        BaseHero heroFromSparta = new Monk();
        heroFromSparta.setTeam("Sparta");

        BaseHero heroFromIgo = new Monk();
        heroFromIgo.setTeam("MongoloTatarskoeIgo");
        heroFromIgo.setAllias(Arrays.asList("Sparta", "Persy"));
        System.out.println(heroFromIgo.getInfo());

        BaseHero hero = new Monk();
        System.out.println(hero.getTeam() != null);
    }
}