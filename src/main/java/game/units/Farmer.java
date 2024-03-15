package game.units;

import game.units.interfaces.Arrows;
import game.units.common.BaseHero;
import java.util.ArrayList;

/**
 * Крестьянин
 */
public class Farmer extends BaseHero {
    private static final String HERO_FARMER_D = "Hero_Farmer #%d";
    private int arrows;

    private Farmer(String name, int hp, int arrows) {
        super(name, hp);
        this.arrows = arrows;
    }

    public Farmer(String name) {
        this(name, Arbalester.r.nextInt(100), 1);
    }

    public Farmer() {
        this(String.format(Farmer.HERO_FARMER_D, ++Arbalester.number));
    }

    /**
     * Подносит стрелы
     * @param list  - Принимает список своей команды
     */
    @Override
    public void step(ArrayList<BaseHero> list) {
        BaseHero target = this.findTarget(list);
        if (arrows > 0 && target != null && !target.isDie()) {
            if (target instanceof Arrows &&
                    ((Arrows) target).getArrows() < ((Arrows) target).getMaxArrows()) {
                ((Arrows) target).setArrow(this.arrows--);
            }
        }
    }
}
