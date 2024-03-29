package game.units;

import game.units.common.BaseHero;
import game.units.common.ElixirAbstract;
import game.units.common.InfantryAbstract;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Разбойник
 */
public class Robber extends InfantryAbstract {
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
                .filter(hero -> hero.getTeam() != null
                        && (!hero.getTeam().equals(this.getTeam()) && !hero.getAllias().contains(this.getTeam()))
                        && !hero.isDie()
                        && !this.equals(hero))
                .collect(Collectors.toList());

        if (heroes.isEmpty()) {
            throw new RuntimeException("GameOver!");
        }

        BaseHero target = this.findTarget(heroes);
        if (target != null && !this.isDie() && !target.isDie()) {
            if (this.checkDistance(target) < 2) {
                this.attack(target);
            } else {
                this.move(target);
            }
        }
    }
}
