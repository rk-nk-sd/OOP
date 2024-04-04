package game.base;

import game.units.Arbalester;
import game.units.Farmer;
import game.units.Lancer;
import game.units.Monk;
import game.units.Point;
import game.units.common.BaseHero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamInit {
    public static int HERO_ID = 0;
    public List<BaseHero> teamInitialized(String teamName) {
        List<BaseHero> list = new ArrayList<>();
//        for (int count = 0; count < gb.getBoardSize().getY(); count++) {
        for (int count = 0; count < 10; count++) {
            int newHero = new Random().nextInt(4);
            BaseHero tmp;
            switch (newHero) {
                case 0:
                    tmp = new Monk("Monk_" + HERO_ID++, new Point());
                    tmp.setTeam(teamName);
                    list.add(tmp);
                    break;
                case 1:
                    tmp = new Arbalester("Arbalester_" + HERO_ID++, new Point());
                    tmp.setTeam(teamName);
                    list.add(tmp);
                    break;
                case 2:
                    tmp = new Lancer("Lancer_" + HERO_ID++, new Point());
                    tmp.setTeam(teamName);
                    list.add(tmp);
                    break;
                default:
                    tmp = new Farmer("Farmer_" + HERO_ID++, new Point());
                    tmp.setTeam(teamName);
                    list.add(tmp);
            }
        }
        return list;
    }
}
