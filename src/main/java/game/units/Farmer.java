package game.units;

import game.units.common.BaseHero;
import game.units.common.InfantryAbstract;
import game.units.common.ShooterAbstract;
import game.units.interfaces.other.Arrows;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Крестьянин
 */
public class Farmer extends InfantryAbstract {
    private static final String HERO_FARMER_D = "Hero_Farmer #%d";

    /**
     * Стрелы не заканчиваются, но target-у можно отдать только 1 стрелу за 1 подход,
     * дальше идти к другому target-у, затем можно вернуться к первому.
     */
    private final int arrows;

    private BaseHero lastTarget;

    private Farmer(String name, int hp, Point point,int energy, int arrows) {
        super(name, hp, point, energy);
        this.arrows = arrows;
    }

    public Farmer(String name, Point point) {
        this(name, Arbalester.r.nextInt(100), point, Lancer.r.nextInt(20), 1);
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
                .filter(hero -> hero.getTeam() != null
                        && (hero.getTeam().equals(this.getTeam()) || hero.getAllias().contains(this.getTeam()))
                        && !hero.isDie()
                        && hero instanceof ShooterAbstract
                        && ((Arrows) hero).getArrows() < ((Arrows) hero).getMaxArrows()
                        && !this.equals(hero))
                .collect(Collectors.toList());

        if (!heroes.isEmpty() && heroes.size() > 1) {
            heroes = heroes.stream().filter(baseHero -> !baseHero.equals(lastTarget)).collect(
                    Collectors.toList());
        } else {
            lastTarget = null;
        }

        BaseHero target = this.findTarget(heroes);
        if (target != null && !target.isDie() && !this.isDie()) {
            if (this.checkDistance(target) < 2) {
                ((Arrows) target).setArrows(this.arrows);
                lastTarget = target;
                System.out.printf("Игрок %s вручил стрелу игроку %s кол-во стрел у игрока %s: %d\n", this.getName(), target.getName(), target.getName(), ((Arrows) target).getArrows());
            } else {
                this.move(target);
            }
        }
    }
}
