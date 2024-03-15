package game.units;

import game.units.common.BaseHero;
import game.units.common.Mana;

import java.util.ArrayList;

/**
 * Снайпер
 */
public class Sniper extends Mana {
    private static final String HERO_SNIPER_D = "Hero_Sniper #%d";
    private Sniper(String name, int hp, int energy) {
        super(name, hp, energy);
    }

    public Sniper(String name) {
        this(name, Sniper.r.nextInt(100), Sniper.r.nextInt(50));
    }

    public Sniper() {
        this(String.format(Sniper.HERO_SNIPER_D, ++Sniper.number));
    }

    @Override
    public void step(ArrayList<BaseHero> list) {
        BaseHero target = this.findTarget(list);
        if (target != null && !this.isDie()) {
            this.attack(target);
        }
    }
}
