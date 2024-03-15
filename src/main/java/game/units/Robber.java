package game.units;

import game.units.common.BaseHero;
import game.units.common.AbstractElixir;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Разбойник
 */
public class Robber extends AbstractElixir {
    private static final String HERO_ROBBER_D = "Hero_Robber #%d";
    private Robber(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
    }

    public Robber(String name, Point point) {
        this(name, Robber.r.nextInt(100), point, Robber.r.nextInt(50));
    }

    public Robber() {
        this(String.format(Robber.HERO_ROBBER_D, ++Robber.number), new Point());
    }

    @Override
    public void step(List<BaseHero> list) {
        List<BaseHero> heroes;
        heroes = list.stream()
                .filter(hero -> hero.getTeam() != null && !hero.getTeam().equals(this.getTeam()))
                .collect(Collectors.toList());

        BaseHero target = this.findTarget(heroes);
        if (target != null && !this.isDie()) {
            this.attack(target);
        }
    }
}
