package game.units;

import game.units.common.BaseHero;
import game.units.common.AbstractElixir;

import java.util.ArrayList;

/**
 * Монах
 */
public class Monk extends AbstractElixir {
    private static final String HERO_MONK_D = "Hero_Monk #%d";
    private Monk(String name, int hp, int energy) {
        super(name, hp, energy);
    }

    public Monk(String name) {
        this(name, Monk.r.nextInt(100), Monk.r.nextInt(50));
    }

    public Monk() {
        this(String.format(Monk.HERO_MONK_D, ++Monk.number));
    }

    /**
     * Лечит
     * @param list - Принимает список своей команды
     */
    @Override
    public void step(ArrayList<BaseHero> list) {
        BaseHero target = this.findTarget(list);
        if (target != null && !target.isDie()) {
            target.healed(2);
        }
    }
}
