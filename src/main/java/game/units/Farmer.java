package game.units;

import game.units.common.BaseHero;
import game.units.interfaces.other.Arrows;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Крестьянин
 */
public class Farmer extends BaseHero {
    private static final String HERO_FARMER_D = "Hero_Farmer #%d";
    private int arrows;

    private Farmer(String name, int hp, Point point, int arrows) {
        super(name, hp, point);
        this.arrows = arrows;
    }

    public Farmer(String name, Point point) {
        this(name, Arbalester.r.nextInt(100), point, 1);
    }

    public Farmer() {
        this(String.format(Farmer.HERO_FARMER_D, ++Arbalester.number), new Point());
    }

    /**
     * Подносит стрелы
     * @param list  - Принимает список своей команды
     */
    @Override
    public void step(List<BaseHero> list) {
        List<BaseHero> heroes;
        heroes = list.stream()
                .filter(hero -> hero.getTeam() != null && hero.getTeam().equals(this.getTeam()))
                .collect(Collectors.toList());

        BaseHero target = this.findTarget(heroes);
        if (arrows > 0 && target != null && !target.isDie()) {
            if (target instanceof Arrows &&
                    ((Arrows) target).getArrows() < ((Arrows) target).getMaxArrows()) {
                ((Arrows) target).setArrows(this.arrows--);
            }
        }
    }
}
