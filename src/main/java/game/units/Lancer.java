package game.units;

import game.units.common.BaseHero;
import game.units.common.InfantryAbstract;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Копейщик
 */
public class Lancer extends InfantryAbstract {
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

    /**
     * Пехотинец
     * @param list - Принимает список противников
     */
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
        if (!this.isDie() && target != null && !target.isDie()) {
            if (this.checkDistance(target) < 2) {
                this.attack(target);
            } else {
                this.move(target); //позиция 9:9 не ходит
            }
            System.out.printf("%s %s -> %s %s hp:%s\n", this.getName(), this.getPoint(), target.getName(), target.getPoint(), target.getHp());
        }
    }
}
