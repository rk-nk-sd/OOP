package game.units;

import game.units.common.BaseHero;
import game.units.common.Mana;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Копейщик
 */
public class Lancer extends Mana {
    private static final String HERO_LANCER_D = "Hero_Lancer #%d";
    private Lancer(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
    }

    public Lancer(String name, Point point) {
        this(name, Lancer.r.nextInt(100), point, Lancer.r.nextInt(50));
    }

    public Lancer() {
        this(String.format(Lancer.HERO_LANCER_D, ++Lancer.number), new Point());
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
