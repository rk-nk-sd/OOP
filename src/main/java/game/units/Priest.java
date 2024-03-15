package game.units;

import game.units.common.BaseHero;
import game.units.common.AbstractElixir;
import game.units.interfaces.Elixir;

import java.util.ArrayList;

/**
 * Жрец
 */
public class Priest extends AbstractElixir {
    private static final String HERO_PRIEST_D = "Hero_Priest #%d";

    private Priest(String name, int hp, int elixir) {
        super(name, hp, elixir);
    }

    public Priest(String name) {
        this(name, Priest.r.nextInt(100),Priest.r.nextInt(50));
    }

    public Priest() {
        this(String.format(Priest.HERO_PRIEST_D, ++Priest.number));
    }

    /**
     * Лечит
     * @param list - Принимает список своей команды
     */
    @Override
    public void step(ArrayList<BaseHero> list) {
        BaseHero target = this.findTarget(list);
        if (this.getElixir() > 1 && target != null && !target.isDie()) {
            if (target instanceof Elixir) {
                this.shareElixir((Elixir) target);
            }
        }
    }
}
