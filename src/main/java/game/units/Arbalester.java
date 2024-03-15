package game.units;

import game.units.interfaces.Arrows;
import game.units.common.BaseHero;
import game.units.common.Mana;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Арбалетчик
 */
public class Arbalester extends Mana implements Arrows {
    private static final String HERO_ARBALESTER_D = "Hero_Arbalester #%d";
    private int arrows;
    private final int maxArrows;
    private Arbalester(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
        this.arrows = 10;
        this.maxArrows = this.arrows;
    }

    public Arbalester(String name, Point point) {
        this(name, Arbalester.r.nextInt(100), point, Arbalester.r.nextInt(50));
    }

    public Arbalester() {
        this(String.format(Arbalester.HERO_ARBALESTER_D, ++Arbalester.number), new Point());
    }

    /**
     * При наличии запаса стрел находит ближайшего противника и атакует
     * @param list - Принимает список команды противника
     */
    @Override
    public void step(List<BaseHero> list) {
        List<BaseHero> heroes;
        heroes = list.stream()
                .filter(hero -> hero.getTeam() != null && !hero.getTeam().equals(this.getTeam()))
                .collect(Collectors.toList());

        BaseHero target = this.findTarget(heroes);
        if (arrows > 0 && target != null && !target.isDie()) {
            this.attack(target);
            this.arrows--;
        }
    }

    @Override
    public int getArrows() {
        return this.arrows;
    }

    @Override
    public int getMaxArrows() {
        return this.maxArrows;
    }

    @Override
    public void setArrow(int count) {
        if (count > 1 && this.arrows < this.maxArrows) this.arrows++;
    }
}
