package game;

import game.units.common.BaseHero;
import game.units.Magician;
import game.units.Priest;

public class App {
    public static void main(String[] args) {
        BaseHero hero_magician = new Magician();
        System.out.println(hero_magician.getInfo());

        BaseHero hero_priest = new Priest();
        System.out.println(hero_priest.getInfo());

        BaseHero hero_priest2 = new Priest();
        System.out.println(hero_priest2.getInfo());

        System.out.println("------------------------");

        System.out.println(hero_priest.getInfo());
        hero_magician.attack(hero_priest);
        System.out.println(hero_priest.getInfo());

        System.out.println("------------------------");

        System.out.println(hero_magician.getInfo());
        hero_priest.attack(hero_magician);
        System.out.println(hero_magician.getInfo());
    }
}
