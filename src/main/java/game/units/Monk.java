package game.units;

import game.units.common.BaseHero;
import game.units.common.HealersMoveImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Монах
 */
public class Monk extends HealersMoveImpl {
    private static final String HERO_MONK_D = "Hero_Monk #%d";
    private BaseHero lastTarget;
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
                .filter(hero -> hero.getTeam() != null
                        && (hero.getTeam().equals(this.getTeam()) || hero.getAllias().contains(this.getTeam()))
                        && !hero.isDie()
                        && hero.getHp() < hero.getMaxHp()
                        && !this.equals(hero))
                .collect(Collectors.toList());

        if (!heroes.isEmpty() && heroes.size() > 1) {
            heroes.removeIf(hero -> hero.equals(lastTarget));
        } else {
            lastTarget = null;
        }

        BaseHero target = this.findTarget(heroes);
        if (target != null && !target.isDie() && !this.isDie()) {
            if (this.checkDistance(target) < 2) {
                target.healed(2);
                lastTarget = target;
            } else {
                this.move(target);
            }
        }
    }
}
