package game.units;

import game.units.common.BaseHero;
import game.units.common.AbstractElixir;
import game.units.interfaces.Elixir;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Жрец
 */
public class Priest extends AbstractElixir {
    private static final String HERO_PRIEST_D = "Hero_Priest #%d";

    private Priest(String name, int hp, Point point, int elixir) {
        super(name, hp, point, elixir);
    }

    public Priest(String name, Point point) {
        this(name, Priest.r.nextInt(100), point, Priest.r.nextInt(50));
    }

    public Priest() {
        this(String.format(Priest.HERO_PRIEST_D, ++Priest.number), new Point());
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
        if (this.getElixir() > 1 && target != null && !target.isDie()) {
            if (target instanceof Elixir) {
                this.shareElixir((Elixir) target);
            }
        }
    }
}
