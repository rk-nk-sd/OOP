package game.units.common;

import game.units.Point;
import game.units.interfaces.healer.Elixir;

public abstract class HealerAbstract extends BaseHero implements Elixir {
    protected HealerAbstract(String name, int hp, Point point) {
        super(name, hp, point);
    }

    public HealerAbstract(String name, Point point) {
        super(name, point);
    }

    public HealerAbstract() {
    }
}
