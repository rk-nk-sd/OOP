package game;

import game.base.TeamInit;
import game.units.common.BaseHero;
import game.base.GameBoard;
import game.units.common.Heroes;

import java.util.*;

public class GameBoardTest {
    private static boolean endGame;
    private final List<BaseHero> list;
    private final GameBoard worldWar;

    public GameBoardTest() {
        this.list = new TeamInit().teamInitialized("Troya");
        list.addAll(new TeamInit().teamInitialized("MongoloTatarskoeIgo"));

        worldWar = new GameBoard(list);
    }

    public static void main(String[] args) {
        GameBoardTest test = new GameBoardTest();

        test.worldWar.view();


        while (!endGame){
            try {
                List<BaseHero> heroes = new ArrayList<>(test.worldWar.getListHeroes());
                heroes.sort((o1, o2) -> Heroes.valueOf(o2.getClass().getSimpleName()).getSpeed()
                        - Heroes.valueOf(o1.getClass().getSimpleName()).getSpeed());
                for (BaseHero hero : heroes) {
                    hero.step(test.worldWar.getListHeroes());
                }
                test.worldWar.view();
            } catch (RuntimeException e) {
                test.worldWar.view();
                endGame = Boolean.TRUE;
                return;
            }
        }
    }
}
