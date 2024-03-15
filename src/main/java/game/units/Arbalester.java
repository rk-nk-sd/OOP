package game.units;

import game.units.interfaces.Arrows;
import game.units.common.BaseHero;
import game.units.common.Mana;

import java.util.ArrayList;

/**
 * Арбалетчик
 */
public class Arbalester extends Mana implements Arrows {
    private static final String HERO_ARBALESTER_D = "Hero_Arbalester #%d";
    private int arrows;
    private int maxArrows;
    private Arbalester(String name, int hp, int energy) {
        super(name, hp, energy);
        this.maxArrows = this.arrows = 10;
    }

    public Arbalester(String name) {
        this(name, Arbalester.r.nextInt(100), Arbalester.r.nextInt(50));
    }

    public Arbalester() {
        this(String.format(Arbalester.HERO_ARBALESTER_D, ++Arbalester.number));
    }

    /**
     * При наличии запаса стрел находит ближайшего противника и атакует
     * @param list - Принимает список команды противника
     */
    @Override
    public void step(ArrayList<BaseHero> list) {
        BaseHero target = this.findTarget(list);
        if (arrows > 0 && target != null && !target.isDie()) {
            this.attack(target);
            this.arrows--;
        }
    }

    @Override
    public int getArrows() {
        return this.arrows;
    }

    @Override
    public int getMaxArrows() {
        return this.maxArrows;
    }

    @Override
    public void setArrow(int count) {
        if (count > 1 && this.arrows < this.maxArrows) this.arrows++;
    }
}
