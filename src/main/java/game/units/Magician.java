package game.units;

import game.units.common.BaseHero;
import game.units.common.ManaAbstract;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Маг
 */
public class Magician extends ManaAbstract {
    private static final String HERO_MAGICIAN_D = "Hero_Magician #%d";

    private Magician(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
    }

    public Magician(String name, Point point) {
        this(name, Magician.r.nextInt(100), point, Magician.r.nextInt(50));
    }

    public Magician() {
        this(String.format(Magician.HERO_MAGICIAN_D, ++Magician.number), new Point());
    }

    /**
     * Может оживить
     * @param list - Принимает список своей команды
     */
    @Override
    public void step(List<BaseHero> list) {
        List<BaseHero> heroes;
        heroes = list.stream()
                .filter(hero -> hero.getTeam() != null && hero.getTeam().equals(this.getTeam()))
                .collect(Collectors.toList());

        BaseHero target = this.findTarget(heroes);
        if (target != null && target.isDie()) {
            target.healed(1);
        }
    }
}
