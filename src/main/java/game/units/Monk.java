package game.units;

import game.units.common.BaseHero;
import game.units.common.ElixirAbstract;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Монах
 */
public class Monk extends ElixirAbstract {
    private static final String HERO_MONK_D = "Hero_Monk #%d";
    private Monk(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
    }

    public Monk(String name, Point point) {
        this(name, Monk.r.nextInt(100), point, Monk.r.nextInt(50));
    }

    public Monk() {
        this(String.format(Monk.HERO_MONK_D, ++Monk.number), new Point());
    }

    /**
     * Лечит
     * @param list - Принимает список своей команды
     */
    @Override
    public void step(List<BaseHero> list) {
        List<BaseHero> heroes;
        heroes = list.stream()
                .filter(hero -> hero.getTeam() != null && hero.getTeam().equals(this.getTeam()))
                .collect(Collectors.toList());

        BaseHero target = this.findTarget(heroes);
        if (target != null && !target.isDie()) {
            target.healed(2);
        }
    }
}
