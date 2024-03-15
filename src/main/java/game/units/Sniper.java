package game.units;

import game.units.common.BaseHero;
import game.units.common.Mana;
import java.util.List;
import java.util.stream.Collectors;

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
